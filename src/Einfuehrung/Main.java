package Einfuehrung;

public class Main {
    public static void main(String[] args) {
      ThreadsPerExtends perclass =  new ThreadsPerExtends();
      Thread t1 = new Thread(new PerImplements());
      Thread t2 = new Thread(perclass);
      t1.start();
      t2.start();
    }
}
