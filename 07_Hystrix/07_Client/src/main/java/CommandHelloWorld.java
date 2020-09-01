import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * @author C
 */
public class CommandHelloWorld extends HystrixCommand<String> {

    private String name;

    public CommandHelloWorld(String name) {
        //最少配置：指定命令组名
        super(HystrixCommandGroupKey.Factory.asKey("ExampleGroup"));
        this.name = name;
    }

    @Override
    protected String run() {
        return "Hello " + this.name + "! thread:" + Thread.currentThread().getName();
    }

    public static void main(String[] args) {
        //同步执行，阻塞
        CommandHelloWorld commandHelloWorld = new CommandHelloWorld("Synchronous-hystrix");
        String string = commandHelloWorld.execute();
        System.out.println(" 同步====== " + string);
        //异步执行，非阻塞
        commandHelloWorld = new CommandHelloWorld("Asynchronous-hystrix");
        Future<String> future = commandHelloWorld.queue();
        try {
            //future.get()方法如果没有重写fallback方法会报出异常
            string = future.get(100, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
        System.out.println(" 异步====== " + string);

        System.out.println(" 主函数====== " + Thread.currentThread().getName());
    }

}
