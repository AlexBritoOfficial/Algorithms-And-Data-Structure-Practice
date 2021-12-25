package MultiThreading.ThreadProperties;

public class UncaughtExceptionThread extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + " , i: " + i);
            if (i == 5) {
                throw new RuntimeException("UncaughtExceptionThread Exception");
            }
        }
    }

}
