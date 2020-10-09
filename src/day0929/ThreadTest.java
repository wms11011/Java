package day0929;

/**
 * @author 王旻爽
 * 2020/9/29
 * @ClassName ThreadTest.java
 */
public class ThreadTest {

    static int blance = 10000;

    private  static final  Object OBJ = new Object();

    public static void main(String[] args) {

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                synchronized (OBJ) {
                    System.out.println(Thread.currentThread().getName() + "查询余额:" + blance);
                    blance -= 1000;
                    System.out.println(Thread.currentThread().getName() + "取了1000元后" + "余额为："+ blance);
                }
            }
        };

        new Thread(runnable,"wangwu").start();
        new Thread(runnable,"lisi").start();
        new Thread(runnable,"feifei").start();
    }
}
