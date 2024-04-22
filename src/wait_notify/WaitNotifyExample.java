package wait_notify;

public class WaitNotifyExample {
    private static final Object lock = new Object();
    private static boolean productAvailable = false;

    public static void main(String[] args) {
        Thread consumer1Thread = new Thread(new Consumer1());
        Thread consumer2Thread = new Thread(new Consumer2());
        Thread producerThread = new Thread(new Producer());

        System.out.println("consumer start");
        // consumer2Thread.setPriority(10);
        consumer1Thread.start();
        consumer2Thread.start();
        try {
            System.out.println("arbeitet...");
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.println(e);
        }
        System.out.println("producer start");
        producerThread.start();
    }

    static class Producer implements Runnable {
        @Override
        public void run() {
            try {
                Thread.sleep(1000); // Simuliere die Produktion
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            synchronized (lock) {
                productAvailable = true;
                System.out.println("producer: Produkt ist jetzt erstellt.");
                lock.notify(); // Nur ein Thread benachrichtigen
                //lock.notify(); // Beide Threads nacheinander benachrichtigen
                //lock.notifyAll(); // Alle Threads benachrichtigen
            }
        }
    }

    static class Consumer1 implements Runnable {
        @Override
        public void run() {
            synchronized (lock) {
                try {
                    System.out.println("consumer1: Warte auf das Produkt...");
                    lock.wait(); // Warte darauf, dass der Produzent ein Produkt produziert
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                /*
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                 */
                if (productAvailable){
                    System.out.println("consumer1: Produkt wurde konsumiert.");
                }

            }
        }
    }

    static class Consumer2 implements Runnable {
        @Override
        public void run() {
            synchronized (lock) {
                try {
                    System.out.println("consumer2: Warte auf das Produkt...");
                    lock.wait(); // Warte darauf, dass der Produzent ein Produkt produziert
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                if (productAvailable){
                    System.out.println("consumer2: Produkt wurde konsumiert.");
                }

            }
        }
    }
}
