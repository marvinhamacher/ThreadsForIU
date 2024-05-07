package nonConcurrentQueues;

import java.util.ArrayDeque;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;

public class KellnerNonConcurrent extends Thread{

    private ArrayDeque<Integer> backlog;

    public KellnerNonConcurrent(ArrayDeque<Integer> backlog) {
        this.backlog = backlog;
    }

    @Override
    public void run() {
        for(int i = 0; i<20; i++){
            try {
                bestellungAufnehmen();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    public void bestellungAufnehmen() throws InterruptedException {
        Random random = new Random();
        int num = random.nextInt(7);
        this.backlog.add(num);
        System.out.println("\u001B[32mEin mal nummer: " + num +" bitte");
    }
}
