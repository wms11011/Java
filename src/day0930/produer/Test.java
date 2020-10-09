package day0930.produer;

/**
 * 动力节点
 * 2020/9/30
 */
public class Test {
    public static void main(String[] args) {
        //先创建仓库
        MyStorage storage = new MyStorage();

        //创建三个生产者线程
        for (int i = 0; i < 3; i++) {
            new Producer("生产者" + i, storage).start();
        }

        //创建三个消费者线程
        for (int i = 0; i < 3; i++) {
            new Consumer("消费者" + i, storage).start();
        }
    }
}
