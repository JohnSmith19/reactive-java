package reactivejava.connectable;

import io.reactivex.Observable;
import io.reactivex.observables.ConnectableObservable;
import reactivejava.common.CommonUtils;

import java.util.concurrent.TimeUnit;

import static reactivejava.common.Shape.BLUE;
import static reactivejava.common.Shape.GREEN;
import static reactivejava.common.Shape.RED;

public class ConnectableObservableExample {
    public void marbleDiagram() {
        String[] dt = {RED, GREEN, BLUE};
        Observable<String> balls = Observable.interval(100L, TimeUnit.MILLISECONDS)
                .map(Long::intValue)
                .map(i->dt[i])
                .take(dt.length);

        ConnectableObservable<String> source = balls.publish();
        source.subscribe(data -> System.out.println("Subscriber #1 => " + data));
        source.subscribe(data -> System.out.println("Subscriber #2 => " + data));
        source.connect();

        CommonUtils.sleep(250);
        source.subscribe(data -> System.out.println("Subscriber #3 => " + data));
        CommonUtils.sleep(100);
    }
}
