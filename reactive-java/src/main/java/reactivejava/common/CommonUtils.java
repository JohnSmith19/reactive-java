package reactivejava.common;

import java.io.IOException;
import java.net.InetAddress;
import java.util.Random;

public class CommonUtils {
    public static void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
