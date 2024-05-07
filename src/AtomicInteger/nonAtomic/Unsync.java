package AtomicInteger.nonAtomic;

public class Unsync extends Thread {

    public Unsync(String name){
        setName(name);
    }

    public static long counter;

    @Override
    public void run() {
        for (long i = 0L; i < 100L; i++) {
            System.out.println(getName() + counter);
            try {
                sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            counter++;
        }
    }
}