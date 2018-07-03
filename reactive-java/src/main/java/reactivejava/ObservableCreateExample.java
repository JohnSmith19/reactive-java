package reactivejava;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.functions.Consumer;

public class ObservableCreateExample {
    public void create() {
        System.out.println("ObservableCreateExample::create");

        subscribeMethodReference();
    }

    public void subscribeMethodReference() {
        Observable<Integer> source = Observable.create(
                (ObservableEmitter<Integer> emitter)-> {
                    emitter.onNext(100);
                    emitter.onNext(200);
                    emitter.onNext(300);
                    emitter.onComplete();
                });

        // Java 8 Method Reference
        source.subscribe(System.out::println);
    }

    public void subscribeLambda() {
        Observable<Integer> source = Observable.create(
                (ObservableEmitter<Integer> emitter)-> {
                    emitter.onNext(100);
                    emitter.onNext(200);
                    emitter.onNext(300);
                    emitter.onComplete();
                });

        // Lambda Expression
        source.subscribe(data -> System.out.println("Result: " + data));

    }

    public void subscribeAnonymously() {
        Observable<Integer> source = Observable.create(
                (ObservableEmitter<Integer> emitter)-> {
                    emitter.onNext(100);
                    emitter.onNext(200);
                    emitter.onNext(300);
                    emitter.onComplete();
                });

        // Anonymous Object
        source.subscribe(new Consumer<Integer>() {
            @Override
            public void accept(Integer data) throws Exception {
                System.out.println("Result: " + data);
            }
        });
    }
}
