package homework0917;

import java.util.Scanner;

/**
 * @author 王旻爽
 * 2020/9/17
 * @ClassName outOfOrder.java
 */
public class outOfOrder {

    public static void main(String[] args) {
        System.out.println("请输入10个数字：");
        int[] num = new int[10];
        Scanner sc = new Scanner(System.in);
        for(int i = 0; i < num.length; i++) {
            num[i] = sc.nextInt();
        }

        // 乱序输出
        outOfOrderArray(num);
    }

    private static void outOfOrderArray(int[] num){
        int  len = num.length;
        for (int i = 0; i < len-1; i++) {
            double dd = Math.random();
            int index = (int) (dd*(len-i));
            int temp = num[index];
            num[index] = num[len-i-1];
            num[len-i-1] = temp;
        }

        for (int value : num) {
            System.out.print(value + " ");
        }
    }

}
