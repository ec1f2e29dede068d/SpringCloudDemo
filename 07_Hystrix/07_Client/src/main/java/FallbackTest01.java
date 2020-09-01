import com.netflix.config.ConfigurationManager;
import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

import java.util.concurrent.TimeUnit;

/**
 * @author C
 */
public class FallbackTest01 extends HystrixCommand<String> {

    private Integer id;

    public FallbackTest01(Integer id) {
        super(HystrixCommandGroupKey.Factory.asKey("ExampleGroup"));
        this.id = id;
    }

    @Override
    protected String run() {
        if (id % 2 == 0 && id <= 10) {
            return "running run(): " + this.id + "\n";
        } else if (id == 333) {
            return "run with hystrix.command.default.circuitBreaker.forceOpen=false";
        } else {
            try {
                TimeUnit.MILLISECONDS.sleep(2000);
                return "";
            } catch (InterruptedException ignored) {
            }
        }
        return null;
    }

    @Override
    protected String getFallback() {
        System.out.println("running getFallback(): " + this.id);
        return "";
    }

    public static void main(String[] args) {
        int loopNum = 12;
        for (int i = 0; i < loopNum; i++) {
            System.out.print(new FallbackTest01(i).execute());
        }
        ConfigurationManager.getConfigInstance().setProperty("hystrix.command.default.circuitBreaker.forceOpen",
                "false");
        System.out.println(new FallbackTest01(333).execute());
    }
}
