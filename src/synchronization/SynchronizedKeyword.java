package synchronization;

public class SynchronizedKeyword {
    static final Object lock = new Object();
    static int counter = 0;

    public static void main(String[] args) throws InterruptedException {

        Thread thread1 = new Thread(new Increment(), "Thread 1");
        Thread thread2 = new Thread(new Increment(), "Thread 2");
        Thread thread3 = new Thread(new Increment(), "Thread 3");
        //
        thread1.start();
        thread2.start();
        thread3.start();

        Thread.sleep(2000);

        System.out.println(counter);
    }

    static class Increment implements Runnable {
        @Override
        public void run() {
            increment1();
        }
    }

    public static synchronized void increment1(){
        for (int i = 0 ; i < 50; i++) {
            counter++;
            System.out.println(Thread.currentThread().getName());
        }
    }

    public static void increment2(){
        synchronized (lock){
            for (int i = 0 ; i < 50; i++) {
                counter++;
                System.out.println(Thread.currentThread().getName());
            }
        }
    }
}

