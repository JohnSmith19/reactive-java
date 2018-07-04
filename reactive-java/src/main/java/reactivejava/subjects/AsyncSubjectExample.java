package reactivejava.subjects;

import io.reactivex.Observable;
import io.reactivex.subjects.AsyncSubject;

public class AsyncSubjectExample {
    public void marbleDiagram() {
        System.out.println("SingleExample::marbleDiagram()");

        AsyncSubject<String> subject = AsyncSubject.create();
        subject.subscribe(data -> System.out.println("Subscriber #1 => " + data));
        subject.onNext("red");
        subject.onNext("green");
        subject.subscribe(data -> System.out.println("Subscriber #2 => " + data));
        subject.onNext("blue");
        subject.onComplete();
    }

    /**
     * AsyncSubject class 가 구독자로 동작한다.
     */
    public void asSubscriber() {
        System.out.println("SingleExample::asSubscriber()");

        Float[] temperature = {10.1f, 13.4f, 12.5f};
        Observable<Float> source = Observable.fromArray(temperature);

        AsyncSubject<Float> subject = AsyncSubject.create();
        subject.subscribe(data -> System.out.println("Subscriber #1 => " + data));

        source.subscribe(subject);
    }

    /**
     * AsyncSubject class 에서 onComplete() 함수를 호출한 후에 구독하는 경우
     * onComplete() 호출 이후에는 onNext 이벤트를 무시한다.
     */
    public void afterComplete() {
        System.out.println("SingleExample::afterComplete()");

        AsyncSubject<String> subject = AsyncSubject.create();
        subject.onNext("red");
        subject.onNext("green");
        subject.subscribe(data -> System.out.println("Subscriber #1 => " + data));
        subject.onNext("blue");
        subject.onComplete();
        subject.onNext("yellow");
        subject.subscribe(data -> System.out.println("Subscriber #2 => " + data));
        subject.subscribe(data -> System.out.println("Subscriber #3 => " + data));
    }
}
