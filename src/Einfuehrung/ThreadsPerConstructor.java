package Einfuehrung;

public class ThreadsPerConstructor{
    public static void main(String[] args) {
        Thread logicInCons = new Thread(() -> {
            System.out.println("hi");
        });
        logicInCons.start();
    }
}
