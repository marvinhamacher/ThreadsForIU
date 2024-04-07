package Einfuehrung;

public class Main {
    public static void main(String[] args) {
      Thread t1 = new Thread(new PerImplements());
      Thread t2 = new Thread(new ThreadsPerExtends());
      t1.start();
      t2.start();
    }
}
