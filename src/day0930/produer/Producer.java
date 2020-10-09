package day0930.produer;

import java.util.Random;

/**
 * 可以有若干生产者同时生产
 * 动力节点
 * 2020/9/30
 */
public class Producer extends  Thread{
    //生产者使用的仓库
    private MyStorage storage ;

    //构造方法初始化
    public Producer(String name, MyStorage storage) {
        super(name);
        this.storage = storage;
    }

    @Override
    public void run() {
        Random random = new Random();
        //约定生产30次
        for (int i = 0; i < 30; i++) {
            storage.add( random.nextInt(100));
        }
    }
}
