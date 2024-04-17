package concurrentHashmaps;

public class Main {
    public static void main(String[] args) {
        // hier ist der Test mit der normalen HashMap
        // null wenn es zu einer MapCollision kommt
        NonConcurrentHashMapThread threadedclass = new NonConcurrentHashMapThread();
        threadedclass.nameFromOutside("A");
        Thread t1 = new Thread(threadedclass);
        threadedclass = new NonConcurrentHashMapThread();
        threadedclass.nameFromOutside("B");
        Thread t2 = new Thread(threadedclass);
        threadedclass = new NonConcurrentHashMapThread();
        threadedclass.nameFromOutside("C");
        Thread t3 = new Thread(threadedclass);
        threadedclass = new NonConcurrentHashMapThread();
        threadedclass.nameFromOutside("D");
        Thread t4 = new Thread(threadedclass);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        System.out.println("\n\n\n\n");
        ConcurrentHashMapThread threadedclass2 = new ConcurrentHashMapThread();
        threadedclass2.nameFromOutside("E");
        Thread t5 = new Thread(threadedclass2);
        threadedclass2 = new ConcurrentHashMapThread();
        threadedclass2.nameFromOutside("F");
        Thread t6 = new Thread(threadedclass2);
        threadedclass2 = new ConcurrentHashMapThread();
        threadedclass2.nameFromOutside("G");
        Thread t7 = new Thread(threadedclass2);
        threadedclass2 = new ConcurrentHashMapThread();
        threadedclass2.nameFromOutside("H");
        Thread t8 = new Thread(threadedclass2);
        t5.start();
        t6.start();
        t7.start();
        t8.start();
    }
}
