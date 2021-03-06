package reactivejava.subjects;

public class SubjectTest {
    public void run() {
        System.out.println("====== SubjectTest start ======");

        AsyncSubjectExample ase = new AsyncSubjectExample();
        ase.marbleDiagram();
        ase.asSubscriber();
        ase.afterComplete();

        BehaviorSubjectExample bse = new BehaviorSubjectExample();
        bse.marbleDiagram();

        PublishSubjectExample pse = new PublishSubjectExample();
        pse.marbleDiagram();

        ReplaySubjectExample rse = new ReplaySubjectExample();
        rse.marbleDiagram();

        System.out.println("====== SubjectTest finish ======");
    }
}
