package nonConcurrentQueues;

import java.util.ArrayDeque;
import java.util.concurrent.ArrayBlockingQueue;

public class KochNonConcurrent extends Thread{

    private ArrayDeque<Integer> backlog;

    public KochNonConcurrent(ArrayDeque<Integer> backlog) {
        this.backlog = backlog;
    }

    @Override
    public void run() {
        for(int i = 0; i<10; i++){
            try {
                kochen();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void kochen() throws InterruptedException {
        System.out.println("\u001B[33mBestellungen vorher: " + this );
        Integer m = backlog.removeFirst();
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
