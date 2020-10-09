package day0930.storage;

/**
 * @author 王旻爽
 * 2020/9/30
 * @ClassName Consumer.java
 */
public class Consumer extends Thread {

    private MyStorage storage;

    public Consumer(String name, MyStorage storage) {
        super(name);
        this.storage = storage;
    }

    @Override
    public void run() {
        for (int i = 0; i < 30; i++) {
            storage.get();
        }
    }
}
