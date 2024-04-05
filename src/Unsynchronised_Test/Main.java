package Unsynchronised_Test;

public class Main {
    public static void main(String[] args) {
        Unsync unsyncklasse = new Unsync();
        Thread one = new Thread(unsyncklasse);
        Thread two = new Thread(unsyncklasse);
        one.run();
        two.run();
        try {
            one.join();
            two.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(unsyncklasse);
    }


}
