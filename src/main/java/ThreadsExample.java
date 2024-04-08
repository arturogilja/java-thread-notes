public class ThreadsExample {
    public static void main(String[] args) {
        Thread t1 = new Thread(ThreadsExample::hello, "Thread 1");
        Thread t2 = new Thread(ThreadsExample::hello, "Thread 2");
        Thread t3 = new Thread(ThreadsExample::hello, "Thread 3");
        Thread t4 = new Thread(ThreadsExample::hello, "Thread 4");

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }

    public static void hello() {
        for(int i = 0; i < 5; i++) {
            System.out.println("i: " + i + " - Hello from " + Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
