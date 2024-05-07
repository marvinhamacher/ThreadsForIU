package AtomicInteger.IncrementAndGet;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class AtomicLongIncrementAndGet extends Thread {
    public AtomicLongIncrementAndGet(String name){
        setName(name);
    }

    public static AtomicLong counter = new AtomicLong(0L);

    @Override
    public void run() {
        for (long i = 0L; i < 100L; i++) {
            long currentValue = counter.incrementAndGet();
            System.out.println(getName() + currentValue);
            try {
                sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
