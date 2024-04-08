public class ThreadExcercise {
    public static void main(String[] args) {
        Thread even = new EvenThread();
        Thread odd = new Thread(new OddThread());

        even.start();
        odd.start();
    }
}
class EvenThread extends Thread {
    @Override
    public void run() {
        int n = 0, count = 0;
        while (count < 5) {
            if (n % 2 == 0) {
                System.out.print(" " + n);
                count++;
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            n++;
        }
    }
}

class OddThread implements Runnable {
    @Override
    public void run() {
        int n = 0, count = 0;
        while (count < 5) {
            if (n % 2 == 1) {
                System.out.print(" " + n);
                count++;
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            n++;
        }
    }
}
