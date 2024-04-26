package threadgroup;

public class ThreadGroupExample {

    public static void main(String[] args) {

        ThreadGroup group = new ThreadGroup("MeineThreadGruppe");

        Thread thread1 = new Thread(group, new MyRunnable(), "Thread1");
        Thread thread2 = new Thread(group, new MyRunnable(), "Thread2");

        // Starten Sie die Threads
        thread1.start();
        thread2.start();

        // Warten Sie, bis die Threads fertig sind
        try {
            thread1.join();

            thread2.join();
        } catch (InterruptedException e) {
            System.out.println("Ein Thread wurde unterbrochen.");
        }

        // Überprüfen Sie den Status der Thread-Gruppe
        System.out.println("Anzahl der aktiven Threads in der Gruppe: " + group.activeCount());

        // Unterbrechen Sie alle Threads in der Gruppe
        group.interrupt();
    }

    // Eine Runnable-Klasse, die den Code der Threads enthält
    static class MyRunnable implements Runnable {
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + " läuft.");
            try {
                Thread.sleep(2000); // Thread pausiert für 2 Sekunden
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + " wurde unterbrochen.");
            }
            System.out.println(Thread.currentThread().getName() + " beendet.");
        }
    }
}