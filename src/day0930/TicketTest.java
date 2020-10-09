package day0930;

/**
 * @author 王旻爽
 * 2020/9/30
 * @ClassName TicketTest.java
 */
public class TicketTest {

    public static void main(String[] args) {

    }


}


//
class TicketWindow extends Thread{

    Ticket ticket;

    public TicketWindow(String name, Ticket ticket) {
        super(name);
        this.ticket = ticket;
    }

    @Override
    public void run() {
        while (true) {
            if(ticket.remainTicket()){
                return;
            }
            System.out.println(Thread.currentThread().getName()+"卖出了Ticket-"  );
        }
    }
}

// 定义车票类
class Ticket {

    // 车票编号
    private int no = 1;

    // 最大车票数
    private final int MAX = 100;

    // 判断是否还有余票
    public boolean remainTicket(){
        return MAX - no > 0;
    }

}
