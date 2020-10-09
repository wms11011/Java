package homewprk0929;

/**
 * @author 王旻爽
 * 2020/9/29
 * @ClassName ticketTest.java
 */
public class ticketTest implements Runnable{

    private ticket t;

    private String name;

    private int ticketNum;

    public ticketTest(ticket t, String name, int ticketNum) {
        this.t = t;
        this.name = name;
        this.ticketNum = ticketNum;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
            t.buyTicket(ticketNum,name);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
