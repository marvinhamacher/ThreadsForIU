package nonConcurrentQueues;

import java.util.ArrayDeque;


public class Restaurant {
    public static ArrayDeque<Integer> menu;
    public static void main(String[] args) {
        menu = new ArrayDeque<>(5);
        Thread t1 = new Thread(new KochNonConcurrent(menu));
        Thread t2 = new Thread(new KellnerNonConcurrent(menu));
        Thread t3 = new Thread(new KochNonConcurrent(menu));
        t2.start();
        t3.start();
        t1.start();
    }
}
