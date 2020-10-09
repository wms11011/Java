package day0930.produer;

/**
 * 动力节点
 * 2020/9/30
 */
public class Consumer extends Thread {
    //消费者使用的仓库
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
