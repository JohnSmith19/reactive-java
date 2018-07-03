package reactivejava.observable;


import io.reactivex.Observable;
import java.util.concurrent.Callable;

public class ObservableFromCallable {
    public void fromCallable() {
        System.out.println("ObservableFromCallable::fromCallable()");

        Callable<String> callable = () -> {
            Thread.sleep(1000);
            return "Hello Callable";
        };

        Observable<String> source = Observable.fromCallable(callable);
        source.subscribe(System.out::println);
    }

    public void fromCallableWithoutLabmda() {
        System.out.println("ObservableFromCallable::fromCallableWithoutLabmda()");

        Callable<String> callable = new Callable<String>() {
            @Override
            public String call() throws Exception {
                Thread.sleep(1000);
                return "Hello Callable";
            }
        };

        Observable<String> source = Observable.fromCallable(callable);
        source.subscribe(System.out::println);
    }
}
