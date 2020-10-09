package day0929;

/**
 * @author 王旻爽
 * 2020/9/29
 * @ClassName DaemonTest.java
 */
public class DaemonTest {

    public static void main(String[] args) {

         Thread t = new BakDataThread();

         t.setName("备份专用");
         t.setDaemon(true);
         t.start();

         // 用户线程
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + "----->" + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class BakDataThread extends Thread {

    @Override
    public void run() {
        int i = 0;
        while (true) {
            System.out.println(Thread.currentThread().getName() + "----->" + (i++));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
