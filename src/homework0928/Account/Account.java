package homework0928.Account;

import java.util.Objects;

/**
 * @author 王旻爽
 * 2020/9/28
 * @ClassName Account.java
 */
public class Account {

    private String user;

    private int blance;

    public Account() {
    }

    public Account(String user, int blance) {
        this.user = user;
        this.blance = blance;
    }

    public  synchronized void getMoney(int money){
        setBlance(getBlance()-money);
        System.out.println(getUser() + "取了" + money + "元" + "余额为" + getBlance());
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public int getBlance() {
        return blance;
    }

    public void setBlance(int blance) {
        this.blance = blance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Account)) return false;
        Account account = (Account) o;
        return Objects.equals(user, account.user) &&
                Objects.equals(blance, account.blance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user, blance);
    }

    @Override
    public String toString() {
        return "Account{" +
                "user='" + user + '\'' +
                ", blance='" + blance + '\'' +
                '}';
    }
}
