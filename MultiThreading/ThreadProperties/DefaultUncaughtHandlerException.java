package MultiThreading.ThreadProperties;


public class DefaultUncaughtHandlerException {
    /**
     * This example demonstrates use of Global exception handler
     **/
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

}
