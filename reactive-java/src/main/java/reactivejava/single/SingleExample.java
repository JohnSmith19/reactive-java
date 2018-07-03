package reactivejava.single;

import io.reactivex.Observable;
import io.reactivex.Single;
import reactivejava.common.Order;

public class SingleExample {
    public void just() {
        System.out.println("SingleExample::just()");
        Observable<String> source = Observable.just("Hello Single");
        source.subscribe(System.out::println);
    }

    public void fromObservable() {
        System.out.println("SingleExample::fromObservable()");

        // 1. 기존 Observable 에서 Single 객체로 변환
        Observable<String> source = Observable.just("Hello Single");
        Single.fromObservable(source)
                .subscribe(System.out::println);

        // 2. single() 함수를 호출해 Single 객체 생성.
        Observable.just("Hello Single")
                .single("default item")
                .subscribe(System.out::println);

        // 3.first() 함수를 호출해 Single 객체 생성.
        String[] colors = {"Red", "Blue", "Gold"};
        Observable.fromArray(colors)
                .first("default value")
                .subscribe(System.out::println);

        // 4. empty Observable 에서 Single 생성.
        Observable.empty()
                .single("default value")
                .subscribe(System.out::println);

        // 5. take() 함수에서 Single 생성
        Observable.just(new Order("ORD-1"), new Order("ORD-2"))
                .take(1)
                .single(new Order("default order"))
                .subscribe(System.out::println);
    }

    public void errorCase() {
        System.out.println("SingleExample::errorCase()");

        Single<String> source = Observable
                .just("Hello Single", "Error").single("default item");
        source.subscribe(System.out::println);
    }

}
