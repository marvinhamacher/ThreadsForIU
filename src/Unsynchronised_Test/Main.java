package Unsynchronised_Test;

public class Main {
    public static void main(String[] args) {
        Unsync unsyncklasse = new Unsync();
        Thread one = new Thread(unsyncklasse);
        Thread two = new Thread(unsyncklasse);
        Thread three = new Thread(unsyncklasse);
        Thread four = new Thread(unsyncklasse);
        one.start();
        two.start();
        three.start();
        four.start();
        try {
            one.join();
            two.join();
            three.join();
            four.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(unsyncklasse);
    }


}
