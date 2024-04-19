package AtomicInteger.compareAndSet;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Thread t4 = new Thread(new AtomicLongCompareAndSet("Thread 4 "));
        Thread t5 = new Thread(new AtomicLongCompareAndSet("Thread 5 "));
        Thread t6 = new Thread(new AtomicLongCompareAndSet("Thread 6 "));
        t4.start();
        t5.start();
        t6.start();
        t4.join();
        t5.join();
        t6.join();
    }
}
