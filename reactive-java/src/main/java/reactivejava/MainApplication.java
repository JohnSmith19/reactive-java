package reactivejava;

import java.util.Observable;

public class MainApplication {
    public static void main(String args[]) {
        FirstExample firstExample = new FirstExample();
        firstExample.emit();

        ObservableNotifications on = new ObservableNotifications();
        on.emit();
    }
}
