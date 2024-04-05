package executorservice;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceExample {
    public static void main(String[] args) {
        // Erstellen eines Thread-Pools mit 2 Threads
        ExecutorService threadPool = Executors.newFixedThreadPool(3);

        // Ausführen von Thread A und Thread B im Thread-Pool
        threadPool.execute(new MyRunnableA());
        threadPool.execute(new MyRunnableB());
        threadPool.execute(new MyRunnableA());
        threadPool.execute(new MyRunnableB());

        System.out.println("Fertig");
        // Beenden des Thread-Pools nachdem alle Aufgaben abgeschlossen sind
        threadPool.shutdown();
    }

    static class MyRunnableA implements Runnable {
        @Override
        public void run() {
            for (int i = 1; i <= 5; i++) { // Führe die Schleife 5 mal aus
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
            for (int i = 1; i <= 5; i++) { // Führe die Schleife 5 mal aus
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
