package SingletonExample;

public class SingletonExample {

    public static SingletonExample INSTANCE;

    public SingletonExample() {
        this.INSTANCE = (SingletonExample) this;
        System.out.println("Hello I am Singleton");
    }

    static {
        new SingletonExample();
    }

    public static void main(String[] args) {
        SingletonExample singletonExample = SingletonExample.INSTANCE;
    }
}
