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
        for(int i = 0; i<35; i++){
            try {
                kochen();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void kochen() throws InterruptedException {
            Integer m = backlog.take();
            System.out.println("Gericht: " + m + " ist fertig");
            System.out.println(backlog);
    }
}
