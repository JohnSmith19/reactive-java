package reactivejava.subjects;

import io.reactivex.subjects.PublishSubject;

public class PublishSubjectExample {
    public void marbleDiagram() {
        System.out.println("PublishSubjectExample::marbleDiagram()");

        PublishSubject<String> subject = PublishSubject.create();
        subject.subscribe(data -> System.out.println("Subscriber #1 => " + data));
        subject.onNext("red");
        subject.onNext("green");
        subject.subscribe(data -> System.out.println("Subscriber #2 => " + data));
        subject.onNext("blue");
        subject.onComplete();
    }
}
