package reactivejava.subjects;

import io.reactivex.subjects.ReplaySubject;

public class ReplaySubjectExample {
    public void marbleDiagram() {
        System.out.println("ReplaySubjectExample::marbleDiagram()");

        ReplaySubject<String> subject = ReplaySubject.create();
        subject.subscribe(data -> System.out.println("Subscriber #1 => " + data));
        subject.onNext("red");
        subject.onNext("green");
        subject.subscribe(data -> System.out.println("Subscriber #2 => " + data));
        subject.onNext("blue");
        subject.onComplete();
    }
}
