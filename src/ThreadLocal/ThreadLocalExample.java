package ThreadLocal;

public class ThreadLocalExample extends Thread {

    public ThreadLocalExample(String name) {
        setName(name);
    }

    public static ThreadLocal<Integer> counter = ThreadLocal.withInitial(()->1);

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println(getName() + counter.get());
            try {
                sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            counter.set(counter.get()+1);
        }
    }
}

