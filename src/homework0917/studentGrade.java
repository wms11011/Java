package homework0917;

import java.util.Scanner;

/**
 * @author 王旻爽
 * 2020/9/17
 * @ClassName studentGrade.java
 */
public class studentGrade {
    public static void main(String[] args) {
        System.out.println("请输入10个学生的成绩：");
        double[] grades = new double[10];
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < grades.length; i++) {
            grades[i] = sc.nextDouble();
        }

        System.out.println("最高分为：" + maxGrade(grades));

    }

    private static double maxGrade(double[] grade){
        for (int i = 0; i < grade.length-1; i++) {
            for (int j = 0; j < grade.length-1-i; j++) {
                if(grade[j] < grade[j+1]){
                    double temp = grade[j];
                    grade[j] = grade[j+1];
                    grade[j+1] = temp;
                }
            }
        }
        return  grade[0];
    }
}
