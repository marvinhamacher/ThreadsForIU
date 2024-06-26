package BlockingQueues;

import java.util.Deque;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CountDownLatch;

public class Koch extends Thread{

    private ArrayBlockingQueue<Integer> backlog;

    public Koch(ArrayBlockingQueue<Integer> backlog) {
        this.backlog = backlog;
    }

    @Override
    public void run() {
        for(int i = 0; i<10; i++){
            try {
                sleep(10);
                kochen();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void kochen() throws InterruptedException {
        System.out.println("\u001B[33mBestellungen vorher: " + this );
        Integer m = backlog.take();
        System.out.println("\u001B[31mGericht: " + m + " ist fertig");
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(int i : this.backlog){
            sb.append(i);
            sb.append(", ");
        }
        return sb.toString();
    }
}
