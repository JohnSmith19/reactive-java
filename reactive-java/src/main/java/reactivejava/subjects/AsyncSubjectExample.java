package reactivejava.subjects;

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
}
