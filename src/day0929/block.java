package day0929;

/**
 * @author 王旻爽
 * 2020/9/29
 * @ClassName block.java
 */
public class block {

    public static void main(String[] args) {

        Prime p = new Prime();

        Runnable r = new Runnable() {
            @Override
            public void run() {
                p.run();
            }
        };

        Thread t1 = new Thread(r,"t1");
        Thread t2 = new Thread(r,"t2");
        t1.start();
        t2.start();
    }
}

class Prime implements Runnable {
    @Override
    public void run() {
        synchronized (this) {
            for (int i = 0; i < 100; i++) {
                System.out.println(Thread.currentThread().getName() + "---->" + i);
            }
        }
    }
}
