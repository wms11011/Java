package homework0917;

/**
 * @author 王旻爽
 * 2020/9/17
 * @ClassName quantityOfA.java
 */
public class quantityOfA {
    public static void main(String[] args) {
        initCharArray();
    }

    private static void initCharArray(){

        char[] c = new char[100];
        for (int i = 0; i < c.length; i++) {
            double dd = Math.random();
            int x = (int) (dd*26);
            c[i] = (char) ('a'+ x);
        }

        int sum = 0;
        for (int i = 0; i < c.length; i++) {
            if (c[i] == 'a') sum++;
        }

        System.out.println("数组中a的个数为" + sum);
        int[] count = new int[26];
        for (int i = 0; i < c.length; i++) {
            count[c[i] - 'a']++;
        }
        for (char i = 'a'; i <= 'z'; i++) {
            System.out.println(i + "的个数为" + count[i-'a']);
        }
    }
}
