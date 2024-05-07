package AtomicInteger.compareAndSet;

import java.util.concurrent.atomic.AtomicLong;

public class AtomicLongCompareAndSet extends Thread{
    public static AtomicLong counter = new AtomicLong(1L);

    public AtomicLongCompareAndSet(String name){
        setName(name);
    }

    @Override
    public void run() {
        long currentValue = counter.get();
        for (long i = 0L; i < 100L;i++) {
            while(!counter.compareAndSet(currentValue,currentValue+1)){
                currentValue = counter.get();
                System.out.println(getName() + currentValue);
            }
            // Increment and Get Implementation benötigt.
            System.out.println(getName() + currentValue);
            try {
                sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
