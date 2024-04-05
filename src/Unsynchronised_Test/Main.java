package Unsynchronised_Test;

public class Main {
    public static void main(String[] args) {
        Unsync unsyncklasse = new Unsync();
        Thread one = new Thread(unsyncklasse);
        Thread two = new Thread(unsyncklasse);
        Thread three = new Thread(unsyncklasse);
        Thread four = new Thread(unsyncklasse);
        Thread five = new Thread(unsyncklasse);
        Thread six = new Thread(unsyncklasse);
        Thread seven = new Thread(unsyncklasse);
        Thread eight = new Thread(unsyncklasse);
        one.run();
        two.run();
        three.run();
        four.run();
        five.run();
        six.run();
        seven.run();
        eight.run();
        try {
            one.join();
            two.join();
            three.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(unsyncklasse);
    }


}
