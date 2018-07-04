package reactivejava.subjects;

public class SubjectTest {
    public void run() {
        System.out.println("====== SubjectTest start ======");

        AsyncSubjectExample ase = new AsyncSubjectExample();
        ase.marbleDiagram();

        System.out.println("====== SubjectTest finish ======");
    }
}
