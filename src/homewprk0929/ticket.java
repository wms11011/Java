package homewprk0929;

/**
 * @author 王旻爽
 * 2020/9/29
 * @ClassName ticket.java
 */
public class ticket {

    private String destPlace;

    private int ticketNum;

    private final static Object OBJ = new Object();

    public ticket() {
    }

    public ticket(String destPlace, int ticketNum) {
        this.destPlace = destPlace;
        this.ticketNum = ticketNum;
    }

    public String getDestPlace() {
        return destPlace;
    }

    public void setDestPlace(String destPlace) {
        this.destPlace = destPlace;
    }

    public int getTicketNum() {
        return ticketNum;
    }

    public void setTicketNum(int ticketNum) {
        this.ticketNum = ticketNum;
    }

    public void buyTicket(int num,String name) {

        synchronized (OBJ) {
            setTicketNum(getTicketNum()-num);

            System.out.println("旅客"+ name + "购买了"+num+"张票，余票为" + getTicketNum());
        }

    }
}
