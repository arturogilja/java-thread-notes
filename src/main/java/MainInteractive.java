public class MainInteractive {
    public static void main(String[] args) {
//        THREAD STATES:
//        NEW - A thread has not yet started
//        RUNNABLE - A thread executing in the JVM
//        BLOCKED - A thread that is blocked waiting for a monitor lock
//        WAITING - A thread that is waiting indefinitely for another thread to perform a particular action
//        TIMED_WAITING - A thread that is waiting for another thread to perform an action for up to a specified waiting time
//        TERMINATED - A thread that has exited

        // Interacting with a running thread
        System.out.println("Main Thread Running");
        try {
            System.out.println("Main thread paused for one second");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

//        Thread thread = new Thread(() -> {
//            String tname = Thread.currentThread().getName();
//            System.out.println(tname + " shoud take 10 dots to run");
//            for (int i = 0; i < 10; i++) {
//                System.out.print(". ");
//                try {
//                    Thread.sleep(500);
//                } catch (InterruptedException e) {
//                    System.out.println("\nWhoops!! " + tname + " interrupted");
//                    return;
//                }
//            }
//            System.out.println("\n" + tname + " completed.");
//        });
        Thread thread = new Thread(() -> {
            String tname = Thread.currentThread().getName();
            System.out.println(tname + " shoud take 10 dots to run");
            for (int i = 0; i < 10; i++) {
                System.out.print(". ");
                try {
                    Thread.sleep(500);
                    System.out.println("A. State = " + Thread.currentThread().getState());
                } catch (InterruptedException e) {
                    System.out.println("\nWhoops!! " + tname + " interrupted");
                    System.out.println("A1. State = " + Thread.currentThread().getState());
                    return;
                }
            }
            System.out.println("\n" + tname + " completed.");
        });


        System.out.println(thread.getName() + " starting");
        thread.start();

        long now = System.currentTimeMillis();
        while(thread.isAlive()) {
            System.out.println("\nWaiting for thread to complete");
            try {
                Thread.sleep(1000);
                System.out.println("B. State = " + thread.getState());
                if(System.currentTimeMillis() - now  > 2000) {
                    thread.interrupt();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

//        System.out.println("Main thread continues");
//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        thread.interrupt();


    }
}
