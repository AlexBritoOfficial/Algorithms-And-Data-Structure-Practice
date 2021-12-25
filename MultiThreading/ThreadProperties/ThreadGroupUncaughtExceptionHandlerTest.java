package MultiThreading.ThreadProperties;

class MyThreadGroup extends ThreadGroup{

    public MyThreadGroup(String name) {
        super(name);
    }

    @Override
    public void uncaughtException(Thread thread, Throwable throwable) {
        ThreadGroup threadGroup = thread.getThreadGroup();
        System.out.println(threadGroup.getName());
        System.out.println(thread.getName()+ "thread end with following exception:::");
        System.out.println(throwable.getMessage());
    }
}

public class ThreadGroupUncaughtExceptionHandlerTest {
    public static void main(String[] args) {

        MyThreadGroup myThreadGroup = new MyThreadGroup("MyThreadGroup");
        Thread thread = new Thread(myThreadGroup, new MyThread(), "T1");
        thread.start();
    }
}


