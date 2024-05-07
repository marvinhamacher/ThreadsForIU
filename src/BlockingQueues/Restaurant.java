package BlockingQueues;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CountDownLatch;


public class Restaurant {
    public static ArrayBlockingQueue<Integer> menu;
    public static void main(String[] args) {
        menu = new ArrayBlockingQueue<>(5);
        Thread t1 = new Thread(new Koch(menu));
        Thread t2 = new Thread(new Kellner(menu));
        Thread t3 = new Thread(new Koch(menu));
        t2.start();
        t3.start();
        t1.start();
    }
}
