package MultiThreading.ThreadProperties;


public class DefaultUncaughtHandlerException {



    public static void main(String[] args) {

        // Register a Default Uncaught Exception Handler for program
        Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                // Perform some sort of work in the method body
                System.out.printf("Thread Name %s ", t.getName());
                System.out.println();
                System.out.printf("Exception: %s", e.getMessage());
            }
        });

        Thread thread = new Thread(new MyThread(), "T1");
        thread.start();
    }

    /**
     * This example demonstrates use of Global exception handler
     **/
    static class MyThread implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + " , i: " + i);
                if (i == 5) {
                    throw new RuntimeException("MyThreads exception");
                }
            }
        }
    }
}
