package day0930.storage;

import java.util.Random;

/**
 * @author 王旻爽
 * 2020/9/30
 * @ClassName Producer.java
 */
public class Producer extends Thread{

    private MyStorage storage;

    public Producer(String name, MyStorage storage) {
        super(name);
        this.storage = storage;
    }

    @Override
    public void run() {
        for (int i = 0;i < 30; i++) {
            storage.add(new Random().nextInt(100));
        }
    }
}
