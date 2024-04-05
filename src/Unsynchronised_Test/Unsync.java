package Unsynchronised_Test;

public class Unsync extends Thread{
    public static int counter;

    @Override
    public void run() {
        for(int i = 0; i<100;i++){
            counter++;
        }
    }
}
