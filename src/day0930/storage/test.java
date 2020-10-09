package day0930.storage;

/**
 * @author 王旻爽
 * 2020/9/30
 * @ClassName test.java
 */
public class test {

    public static void main(String[] args) {
        MyStorage storage = new MyStorage();

        for (int i = 0; i < 5; i++) {
            new Producer("生产者" + i,storage).start();
        }

        for (int i = 0; i < 5; i++) {
            new Consumer("消费者" + i,storage).start();
        }
    }
}
