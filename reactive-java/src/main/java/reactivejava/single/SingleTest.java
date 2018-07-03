package reactivejava.single;

import io.reactivex.Observable;

public class SingleTest {
    public void run() {
        System.out.println("====== SingleTest start ======");

        SingleExample se = new SingleExample();
        se.just();

        se.fromObservable();
        //se.errorCase();

        System.out.println("====== SingleTest finish ======");
    }

}
