package threadpoolexecutorexample;

import java.util.concurrent.*;

public class ThreadPoolExecutorExample {
    public static void main(String[] args) {
        // Erstellen eines ThreadPoolExecutor mit einem Thread
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(4, 4,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>());

        // Einreichen einer Aufgabe an den ThreadPoolExecutor
        threadPool.execute(new MyRunnableA());
        threadPool.execute(new MyRunnableB());
        threadPool.execute(new MyRunnableA());
        threadPool.execute(new MyRunnableB());

        // Beenden des ThreadPoolExecutor
        threadPool.shutdown();
        System.out.println("Ende");
    }

    static class MyRunnableA implements Runnable {
        @Override
        public void run() {
            for(int i = 1; i < 6; i++){
                System.out.println("A: " + i);
                try {
                    Thread.sleep(100); // Pausiere den Thread für 100 Millisekunden
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }

    static class MyRunnableB implements Runnable {
        @Override
        public void run() {
            for(int i = 1; i < 6; i++){
                System.out.println("B: " + i);
                try {
                    Thread.sleep(100); // Pausiere den Thread für 100 Millisekunden
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }
}

