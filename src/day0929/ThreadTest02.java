package day0929;

/**
 * @author 王旻爽
 * 2020/9/29
 * @ClassName ThreadTest02.java
 */
public class ThreadTest02 {

    public static void main(String[] args) {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    System.out.println(Thread.currentThread().getName() +"------"+ Thread.currentThread().isDaemon() + "------" + i);
                }
            }
        },"t");

        t.start();

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 300; i++) {
                    System.out.println(Thread.currentThread().getName() +"------"+ Thread.currentThread().isDaemon() + "------" + i);
                }
            }
        },"t2");

        t2.setDaemon(true);
        t2.start();
    }
}
