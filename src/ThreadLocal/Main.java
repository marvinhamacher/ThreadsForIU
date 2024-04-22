package ThreadLocal;


public class Main {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new ThreadLocalExample("Thread 1 "));
        Thread t2 = new Thread(new ThreadLocalExample("Thread 2 "));
        Thread t3 = new Thread(new ThreadLocalExample("Thread 3 "));
        t1.start();
        t2.start();
        t3.start();
        t1.join();
        t2.join();
        t3.join();
    }
}
