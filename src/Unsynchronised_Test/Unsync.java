package Unsynchronised_Test;

public class Unsync extends Thread{
    public static long counter;

    @Override
    public void run() {
        for(long i = 0L; i<1000L;i++){
            System.out.println(counter);
            try {
                sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            counter++;
        }
    }

    @Override
    public String toString() {
        return ""+counter;
    }
}
