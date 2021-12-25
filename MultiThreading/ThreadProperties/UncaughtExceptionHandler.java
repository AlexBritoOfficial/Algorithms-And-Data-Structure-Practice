package MultiThreading.ThreadProperties;

public class UncaughtExceptionHandler {
    public static void main(String[] args) {

            Thread.currentThread().setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
                @Override
                public void uncaughtException(Thread t, Throwable e) {
                    System.out.printf("Thread Name %s ", t.getName());
                    System.out.println();
                    System.out.printf("Exception: %s", e.getMessage());
                }
            });

            throw new RuntimeException("Exception in main");
    }
}
