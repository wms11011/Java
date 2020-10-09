package day0929;

/**
 * @author 王旻爽
 * 2020/9/29
 * @ClassName deadLock.java
 */
public class deadLock {

    public static void main(String[] args) {

        Object o1 = new Object();
        Object o2 = new Object();

        Thread t1 = new Test01(o1,o2);
        Thread t2 = new Test02(o1,o2);

        t1.start();
        t2.start();

    }

}

class Test01 extends Thread {

    Object o1 = new Object();
    Object o2 = new Object();

    public Test01(Object o1, Object o2) {
        this.o1 = o1;
        this.o2 = o2;
    }

    @Override
    public void run() {
        synchronized (o1){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (o2){

            }
        }
    }
}

class Test02 extends  Thread {

    Object o1 = new Object();
    Object o2 = new Object();

    public Test02(Object o1, Object o2) {
        this.o1 = o1;
        this.o2 = o2;
    }

    @Override
    public void run() {
        synchronized (o2){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (o1){
            }
        }
    }
}
