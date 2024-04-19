package AtomicInteger.compareAndSet;

import java.util.concurrent.atomic.AtomicLong;

public class AtomicLongCompareAndSet extends Thread{
    public AtomicLong counter = new AtomicLong(0L);

    public AtomicLongCompareAndSet(String name){
        setName(name);
    }

    @Override
    public void run() {
        long currentValue = counter.get();
        for (long i = 0L; i < 1000L;) {
            while(!counter.compareAndSet(currentValue,currentValue+1)){
                currentValue = counter.get();
                System.out.println(getName() + currentValue);
            }
            i = currentValue; // setzt i gleich den Current value  da die implementation eine iteration mehr als die
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
