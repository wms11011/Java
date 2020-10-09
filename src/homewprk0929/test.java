package homewprk0929;

/**
 * @author 王旻爽
 * 2020/9/29
 * @ClassName test.java
 */
public class test {
    public static void main(String[] args) {

        ticket t = new ticket("北京",10);

        ticketTest ticketTest = new ticketTest(t,"小李",5);
        ticketTest ticketTest1 = new ticketTest(t,"小王",4);
        ticketTest ticketTest2 = new ticketTest(t,"小马",1);


        Thread t1 = new Thread(ticketTest);
        Thread t2 = new Thread(ticketTest1);
        Thread t3 = new Thread(ticketTest2);

        t1.start();
        t2.start();
        t3.start();

    }
}
