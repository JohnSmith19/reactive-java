package reactivejava;

public class MainApplication {
    public static void main(String args[]) {
        FirstExample firstExample = new FirstExample();
        firstExample.emit();

        // Observable subscribe example
        ObservableNotifications on = new ObservableNotifications();
        on.emit();

        // Observable create example
        ObservableCreateExample oc = new ObservableCreateExample();
        oc.create();
    }
}
