public class CachedData {
    private boolean flag = false;

    public void toggleFlag() {
        flag = !flag;
    }

    public boolean isReady() {
        return flag;
    }

    public static void main(String[] args) {
        CachedData example = new CachedData();

        Thread writerThread = new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            example.toggleFlag();
            System.out.println("A. Flag set to " + example.isReady());
        });

        Thread readerThread = new Thread(() -> {
            while(!example.isReady()) {
                continue;
            }
            System.out.println("B. Flag is now " + example.isReady());
        });

        writerThread.start();
        readerThread.start();

    }
}
