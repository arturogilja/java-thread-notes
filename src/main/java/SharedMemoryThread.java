import java.util.concurrent.TimeUnit;

public class SharedMemoryThread {

    public static void main(String[] args) throws InterruptedException {
        int target = 100_000;
        Counter c = new Counter();

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < target; i++) {
                c.increment();
            }
        });
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < target; i++) {
                c.increment();
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();
        System.out.println("Current value: " + c.count);
    }
}

class Counter {
    int count;
    public synchronized void increment() {
        count++;
    }
}
