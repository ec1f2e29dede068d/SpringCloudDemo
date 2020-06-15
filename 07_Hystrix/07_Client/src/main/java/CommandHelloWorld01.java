import com.netflix.config.ConfigurationManager;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixObservableCommand;
import rx.Observable;
import rx.Subscriber;
import rx.schedulers.Schedulers;

import java.util.Iterator;

public class CommandHelloWorld01 extends HystrixObservableCommand<String> {

    private String name;

    public CommandHelloWorld01(String name) {
        super(HystrixCommandGroupKey.Factory.asKey("ExampleGroup"));
        this.name = name;
    }

    protected Observable<String> construct() {
        return Observable.create(new Observable.OnSubscribe<String>() {
            public void call(Subscriber<? super String> subscriber) {
                try {
                    if (!subscriber.isUnsubscribed()) {
                        subscriber.onNext("Hello ");
                        subscriber.onNext(name + "! thread:");
                        subscriber.onNext(Thread.currentThread().getName());
                        subscriber.onCompleted();
                    }
                } catch (Exception e) {
                    subscriber.onError(e);
                }
            }
        }).subscribeOn(Schedulers.io());
    }

    public static void main(String[] args) {
//        Observable<String> stringObservable = new CommandHelloWorld01("Asynchronous-hystrix").observe();
        Observable<String> stringObservable = new CommandHelloWorld01("Asynchronous-hystrix").toObservable();
        Iterator<String> stringIterator = stringObservable.toBlocking().getIterator();
        while (stringIterator.hasNext()) {
            System.out.print(stringIterator.next());
        }
    }
}
