package homework0928.Account;

/**
 * @author 王旻爽
 * 2020/9/28
 * @ClassName AccountTest.java
 */
public class AccountTest extends Thread{

    private Account act;

    public AccountTest(Account act) {
        this.act = act;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        act.getMoney(5000);
    }
}

