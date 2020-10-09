package homework0917;

import java.util.Scanner;

/**
 * @author 王旻爽
 * 2020/9/17
 * @ClassName reversedArray.java
 */
public class reversedArray {
    public static void main(String[] args) {
        System.out.println("请输入5个字符串：");
        String[] str = new String[5];
        Scanner sc = new Scanner(System.in);
        for(int i = 0; i < str.length; i++) {
            str[i] = sc.next();
        }
        exchangeStr(str);
    }

    private static void exchangeStr(String[] str){

        int max = str.length-1;
        int min = 0;
        for(int i = min,j = max ; i <= j ; i++,j--){
            String temp = str[i];
            str[i] = str[j];
            str[j] = temp;
        }

        for (String s : str) {
            System.out.print(s + " ");
        }
    }
}
