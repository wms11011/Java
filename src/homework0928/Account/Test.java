package homework0928.Account;

/**
 * @author 王旻爽
 * 2020/9/28
 * @ClassName Test.java
 */
public class Test {

    public static void main(String[] args) {
        Account account = new Account("123123",10000);
        Thread t1 = new AccountTest(account);
        Thread t2 = new AccountTest(account);
        t1.start();
        t2.start();
    }


}
