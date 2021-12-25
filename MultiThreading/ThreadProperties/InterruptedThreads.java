package MultiThreading.ThreadProperties;


public class InterruptedThreads {
    public static void main(String[] args) {


        Runnable r = () -> {

            int x = 0;
            try {
                while (x < 5) {
                    for (int i = 0; i < 4; i++) {
                        System.out.println("i value: " + i);
                        Thread.sleep(4000);
                        x++;
                    }
                }

            } catch (InterruptedException exception) {
                System.out.println(exception);
                Thread.currentThread().interrupt();
            }
        };

        Thread thread = new Thread(r);
        thread.start();
        thread.interrupt();
        System.out.println(thread.isInterrupted());

    }
}
