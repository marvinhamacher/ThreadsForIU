package BlockingQueues;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;

public class Kellner extends Thread{

    private ArrayBlockingQueue<Integer> backlog;

    public Kellner(ArrayBlockingQueue<Integer> backlog) {
        this.backlog = backlog;
    }

    @Override
    public void run() {
        for(int i = 0; i<35; i++){
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
        this.backlog.put(num);
        System.out.println("Ein mal nummer: " + num +" bitte");
        System.out.println(backlog);
    }
}
