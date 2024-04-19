package AtomicInteger.IncrementAndGet;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Thread t7 = new Thread(new AtomicLongIncrementAndGet("Thread 7 "));
        Thread t8 = new Thread(new AtomicLongIncrementAndGet("Thread 8 "));
        Thread t9 = new Thread(new AtomicLongIncrementAndGet("Thread 9 "));
        t7.start();
        t8.start();
        t9.start();
        t7.join();
        t8.join();
        t9.join();
    }
}
