package threadpoolfuture;

import java.util.concurrent.*;

public class ThreadPoolFutureExample {
    public static void main(String[] args) {
        // Erstellen eines Thread-Pools mit einem Thread
        ExecutorService threadPool = Executors.newFixedThreadPool(1);

        // Einreichen einer Aufgabe an den Thread-Pool und Erhalt eines Future-Objekts
        Future<Integer> future = threadPool.submit(new MyCallable());

        // Auf das Ergebnis der Aufgabe warten und es ausgeben
        try {
            System.out.println("Warte auf Ergebnis");
            int result = future.get();
            System.out.println("Ergebnis: " + result);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        // Beenden des Thread-Pools
        threadPool.shutdown();
    }

    static class MyCallable implements Callable<Integer> {
        @Override
        public Integer call() throws Exception {
            // Simulieren einer langen Berechnung
            Thread.sleep(2000);
            return 42; // Rückgabewert der Berechnung
        }
    }
}
