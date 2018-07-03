import reactivejava.observable.*;
import reactivejava.single.SingleTest;

public class MainApplication {
    public static void main(String args[]) {
        ObservableTest ot = new ObservableTest();
        ot.run();

        SingleTest st = new SingleTest();
        st.run();
    }
}
