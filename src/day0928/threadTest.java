package day0928;

/**
 * @author 王旻爽
 * 2020/9/28
 * @ClassName threadTest.java
 */
public class threadTest {

    public static void main(String[] args) {

        Thread t = new subThread();

        t.start();

        for (int i = 0; i < 1000; i++) {
            System.out.println("main Thread --------->" + i);
        }
    }
}

class subThread extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println("sub Thread ------->" + i);
        }
    }
}
