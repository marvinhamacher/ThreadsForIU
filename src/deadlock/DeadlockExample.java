package deadlock;

public class DeadlockExample {
    static class Friend {
        private final String name;
        public Friend(String name) {
            this.name = name;
        }
        public String getName() {
            return this.name;
        }
        public synchronized void greet(Friend greeter) {
            System.out.format("%s: %s" + "  has greeted me!%n", this.name, greeter.getName());
            greeter.greetBack(this);
        }
        public synchronized void greetBack(Friend greeter) {
            System.out.format("%s: %s" + " has greeted me back!%n", this.name, greeter.getName());
        }
    }

    public static void main(String[] args) {
        final Friend a = new Friend("A");
        final Friend b = new Friend("B");
        new Thread(new Runnable() {
            public void run() {
                a.greet(b);
            }
        }).start();

        new Thread(new Runnable() {
            public void run() {
                b.greet(a);
            }
        }).start();
    }
}
