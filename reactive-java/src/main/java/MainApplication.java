import reactivejava.observable.*;
import reactivejava.single.SingleTest;
import reactivejava.subjects.SubjectTest;

public class MainApplication {
    public static void main(String args[]) {
        ObservableTest observableTest = new ObservableTest();
        observableTest.run();

        SingleTest singleTest = new SingleTest();
        singleTest.run();

        SubjectTest subjectTest = new SubjectTest();
        subjectTest.run();
    }
}
