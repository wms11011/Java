package homework0923;

import day0923.Student;

import java.util.*;

/**
 * @author 王旻爽
 * 2020/9/23
 * @ClassName studentTest.java
 */
public class studentTest {

    public static void main(String[] args) {

        Set<student> studentSet = new TreeSet<>(new Comparator<student>() {
            @Override
            public int compare(student o1, student o2) {
                return o1.getScore() - o2.getScore();
            }
        });

        while (studentSet.size() < 20){
            String stuid = randomStuId();
            int grade = randomGrade();
            int score = randomScore();
            studentSet.add(new student(stuid,grade,score));
        }

        for (student next : studentSet) {
            System.out.println(next);
        }

    }

    // 生成随机学号
    private static String randomStuId(){
        StringBuilder sb = new StringBuilder();
        for (int i = 0;i < 5;i++) {
            sb.append(String.valueOf(new Random().nextInt(10)));
        }
        String stuId = sb.toString();
        return  stuId;
    }

    // 随机分配班级
    // 生成[start,end]范围内的随机数
    // int i = new Random().nextInt(end) % (end - start + 1) + start
    private static int randomGrade(){
        int grade = new Random().nextInt(10) % 10 + 1;
        return grade;
    }

    // 生成随机分数
    private static int randomScore(){
        int grade = new Random().nextInt(100) % 41 + 60;
        return grade;
    }
}
