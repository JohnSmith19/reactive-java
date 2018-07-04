package reactivejava.subjects;

import io.reactivex.subjects.BehaviorSubject;

public class BehaviorSubjectExample {
    public void marbleDiagram() {
        System.out.println("BehaviorSubjectExample::marbleDiagram()");

        BehaviorSubject<String> subject = BehaviorSubject.createDefault("pink");
        subject.subscribe(data -> System.out.println("Subscriber #1 => " + data));
        subject.onNext("red");
        subject.onNext("green");
        subject.subscribe(data->  System.out.println("Subscriber #2 => " + data));
        subject.onNext("blue");
        subject.onComplete();
    }
}
