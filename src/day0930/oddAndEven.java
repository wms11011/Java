package day0930;

/**
 * @author 王旻爽
 * 2020/9/30
 * @ClassName oddAndEven.java
 */
public class oddAndEven {


    public static void main(String[] args) {

        producer p = new producer();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0;i<100;i++) {
                    synchronized (p) {
                        while(producer.getNum() % 2 != 0){
                            try {
                                p.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        System.out.println(Thread.currentThread().getName() + "----->" + producer.getNum());
                        p.add();
                        p.notify();
                    }
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0;i<100;i++) {
                    synchronized (p) {
                        while(producer.getNum() % 2 == 0){
                            try {
                                p.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                            System.out.println(Thread.currentThread().getName() + "----->" + producer.getNum());
                            p.add();
                            p.notify();
                    }
                }
            }
        });

        t1.setName("t1");
        t2.setName("t2");

        t1.start();
        t2.start();

    }
}

class producer {
    private static int num = 0;

    public static int getNum() {
        return num;
    }

    public int add (){
        return num++;
    }
}

