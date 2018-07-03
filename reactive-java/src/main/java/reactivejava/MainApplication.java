package reactivejava;

import reactivejava.observable.*;

public class MainApplication {
    public static void main(String args[]) {
        FirstExample firstExample = new FirstExample();
        firstExample.emit();

        // observable subscribe example
        ObservableNotifications on = new ObservableNotifications();
        on.emit();

        // observable create example
        ObservableCreateExample oc = new ObservableCreateExample();
        oc.create();

        // observable formArray example
        ObservableFromArray ofa = new ObservableFromArray();
        ofa.fromArray();

        // observable fromIterable example
        ObservableFromIterable ofi = new ObservableFromIterable();
        ofi.fromIterable();

        // observable fromCallable example
        ObservableFromCallable ofc = new ObservableFromCallable();
        ofc.fromCallable();

        // observable fromFuture example
        ObservableFromFuture off = new ObservableFromFuture();
        off.fromFuture();

        // observable fromPublisher example
        ObservableFromPublisher ofp = new ObservableFromPublisher();
        ofp.fromPublisher();
    }
}
