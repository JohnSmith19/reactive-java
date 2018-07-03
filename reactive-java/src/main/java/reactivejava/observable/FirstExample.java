package reactivejava.observable;

import io.reactivex.Observable;

public class FirstExample {
    public void emit() {
        Observable.just(1, 2, 3, 4, 5, 6)
                .subscribe(data->System.out.println(data));
    }

}
