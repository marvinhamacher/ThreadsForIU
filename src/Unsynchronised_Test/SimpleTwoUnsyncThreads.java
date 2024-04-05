package Unsynchronised_Test;

public class SimpleTwoUnsyncThreads{
    public static void main(String []args){
        Thread t1 = new Thread(new A(), "countA");
        System.out.println("Thread has been created: " + t1.getName());
        Thread t2 = new Thread(new B(), "countB");
        System.out.println("Thread has been created: " + t2.getName());

        System.out.println("start counting");
        t1.start();
        t2.start();
    }
}

class A implements Runnable {
    @Override
    public void run(){
        for(int i = 0; i < 100; i++){
            System.out.println("A: " + i);
        }
    }
}

class B implements Runnable {
    @Override
    public void run(){
        for(int i = 0; i < 100; i++){
            System.out.println("B: " + i);
        }
    }
}
