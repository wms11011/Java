package day0929;

/**
 * @author 王旻爽
 * 2020/9/29
 * @ClassName ThreadTest03.java
 */
public class ThreadTest03 {

    public static void main(String[] args) {

        Thread thread = new Thread(new primeC(),"t");

        thread.start();

        // 主线程
        for (int i = 0; i < 30000; i++) {
            System.out.println(Thread.currentThread().getName()+ "--------->" +Thread.currentThread().isInterrupted()+"====="+ i);
        }
        thread.interrupt();

    }
}

class primeC extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 300; i++) {
            System.out.println(Thread.currentThread().getName()+"----->"+Thread.currentThread().isInterrupted()+"===" + i);
            if(i == 100){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
