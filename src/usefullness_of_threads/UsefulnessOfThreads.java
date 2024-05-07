package usefullness_of_threads;

import java.util.concurrent.atomic.AtomicInteger;
public class UsefulnessOfThreads {
    public static void main(String[] args) {
        AtomicInteger myNumber = new AtomicInteger(0);
        // Variable für die Berechnung
        System.out.println("main startet die Arbeit...");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("main gibt Auftrag an RechnerThread");
        // Thread für die Berechnung erstellen und starten
        Thread calculationThread = new Thread(new CalculationTask(myNumber), "RechnerThread");
        calculationThread.start();

        System.out.println("main arbeitet weiter...");
        // Programm "arbeitet" weiter x Sekunden
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Abfrage an den Thread, ob er fertig ist
        if (calculationThread.isAlive()) {
            System.out.println("main: Thread ist noch am Rechnen... Warte bis fertig ist");
            try {
                calculationThread.join(); // warten bis der Thread fertig ist
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Erst jetzt ist der Thread fertig");
        } else {
            System.out.println("main: Thread war schon vorher fertig.");
        }
        // Ausgabe des errechneten Werts
        System.out.println("main: Endwert von myNumber: " + myNumber.get());
    }
}

class CalculationTask implements Runnable {
    private AtomicInteger myNumber;

    public CalculationTask(AtomicInteger myNumber) {
        this.myNumber = myNumber;
    }

    @Override
    public void run() {
        // Berechnung durchführen
        System.out.println("Thread " + Thread.currentThread().getName() + " startet die Berechnung");
        // Thread pausieren damit er eventuell länger braucht als main
        try {
            Thread.sleep(100); // Hier den wert anpassen damit verschiedene Bedingungen zutreffen
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < 10; i++) {
            this.myNumber.addAndGet(1);
        }

        System.out.println("Thread " + Thread.currentThread().getName() + " hat die Berechnung abgeschlossen");
    }
}
