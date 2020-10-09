package homework0917;

import java.util.Scanner;

/**
 * @author 王旻爽
 * 2020/9/17
 * @ClassName calendar.java
 */
public class calendar {

    public static void main(String[] args) {
        // 从键盘上输入日期,
        Scanner sc = new Scanner(System.in);
        System.out.println("请按yyyy MM格式输入日期");
        int year = sc.nextInt();
        int month = sc.nextInt();
        int sum = calculateDay(year,month);
        // 闰年
        int[] leapYear = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        // 平年
        int[] commonYear = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        // 星期
        String[] week = {"一 ","二 ","三 ","四 ","五 ","六 ","日"};
        // 打印表头
        for (int i = 0; i < 7; i++) {
            System.out.print(week[i]+"\t");
        }
        // 换行
        System.out.println();

        int count = sum % 7;
        for (int i = 0; i <= count-1; i++) {
            System.out.print("\t");
        }

        // 打印日历
        if(year % 4 == 0 && year % 100 != 0 || year % 400 == 0){
               for(int i=1;i<=leapYear[month-1];i++) {
               System.out.print(i+"\t");
               if(sum%7 == 6) {
                   System.out.print("\n");
               }
               sum++;
           }
        } else{
            for(int i=1;i<=commonYear[month-1];i++) {
                System.out.print(i+"\t");
                if(sum%7 == 6) {
                    System.out.print("\n");
                }
                sum++;
            }
        }
    }

    /**
     * 计算总天数
     * @param year 年
     * @param month 月
     * @return int 总天数
     */
    private static int calculateDay(int year, int month){

        // 合计天数
         int sumDay = 0;

        // 闰年
        int[] leapYear = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        // 平年
        int[] commonYear = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        // 初始年份
        int initYear = 1900;

        for (int i = initYear; i <= year-1; i++) {
            if(i % 4 == 0 && i % 100 != 0 || i % 400 == 0){
                sumDay += 366;
            } else{
                sumDay += 365;
            }
        }

        if(year % 4 == 0 && year % 100 != 0 || year % 400 == 0){
            // 闰年
            // 累加输入月份之前的完整天数
            for (int i = month - 2; i >= 0; i--) {
                sumDay += leapYear[i];
            }
        } else{
            // 平年
            // 累加输入月份之前的完整天数
            for (int i = month - 2; i >= 0; i--) {
                sumDay += commonYear[i];
            }
        }

        // 返回总天数
        return sumDay;
    }
}
