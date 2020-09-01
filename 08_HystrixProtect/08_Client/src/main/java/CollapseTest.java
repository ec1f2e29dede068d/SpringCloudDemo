import com.netflix.config.ConfigurationManager;
import com.netflix.hystrix.HystrixCollapser;
import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.strategy.concurrency.HystrixRequestContext;

import java.util.*;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @author C
 */
public class CollapseTest {

    public static void main(String[] args) {
        ConfigurationManager.getConfigInstance().setProperty(
                "hystrix.collapser.default.timeInMilliseconds", 1000);
        ConfigurationManager.getConfigInstance().setProperty(
                "hystrix.command.default.execution.timeout.enable", false);
        HystrixRequestContext context = HystrixRequestContext.initializeContext();

        MyHystrixCollapser myHystrixCollapser1 = new MyHystrixCollapser("Angus");
        MyHystrixCollapser myHystrixCollapser2 = new MyHystrixCollapser("Crazyit");
        MyHystrixCollapser myHystrixCollapser3 = new MyHystrixCollapser("Sune");
        MyHystrixCollapser myHystrixCollapser4 = new MyHystrixCollapser("Paris");

        Future<Person> future1 = myHystrixCollapser1.queue();
        Future<Person> future2 = myHystrixCollapser2.queue();
        Future<Person> future3 = myHystrixCollapser3.queue();
        Future<Person> future4 = myHystrixCollapser4.queue();

        try {
            System.out.println(future1.get());
            System.out.println(future2.get());
            System.out.println(future3.get());
            System.out.println(future4.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        context.shutdown();
    }

    static class Person {
        String id;
        String name;
        Integer age;

        @Override
        public String toString() {
            return "id:" + id + ",name:" + name + ",age:" + age;
        }
    }

    static class CollapserCommand extends HystrixCommand<Map<String, Person>> {

        Collection<HystrixCollapser.CollapsedRequest<Person, String>> requests;

        CollapserCommand(Collection<HystrixCollapser.CollapsedRequest<Person, String>> requests) {
            super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("ExampleGroup")));
            this.requests = requests;
        }

        @Override
        protected Map<String, Person> run() throws Exception {
            System.out.println("收集参数后执行命令，参数数量：" + requests.size());
            List<String> personNames = new ArrayList<String>();
            for (HystrixCollapser.CollapsedRequest<Person, String> request : requests) {
                personNames.add(request.getArgument());
            }
            return callService(personNames);
        }

        private Map<String, Person> callService(List<String> personNames) {
            Map<String, Person> result = new HashMap<String, Person>(8);
            for (String personName : personNames) {
                Person person = new Person();
                person.id = UUID.randomUUID().toString();
                person.name = personName;
                person.age = new Random().nextInt(30);
                result.put(personName, person);
            }
            return result;
        }
    }

    static class MyHystrixCollapser extends HystrixCollapser<Map<String, Person>, Person, String> {

        String personName;

        MyHystrixCollapser(String personName) {
            this.personName = personName;
        }

        @Override
        public String getRequestArgument() {
            return personName;
        }

        @Override
        protected HystrixCommand<Map<String, Person>>
        createCommand(Collection<CollapsedRequest<Person, String>> requests) {
            return new CollapserCommand(requests);
        }

        @Override
        protected void mapResponseToRequests(Map<String, Person> batchResponse
                , Collection<CollapsedRequest<Person, String>> requests) {
            for (CollapsedRequest<Person, String> request : requests) {
                Person singleResult = batchResponse.get(request.getArgument());
                request.setResponse(singleResult);
            }
        }
    }
}
