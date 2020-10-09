package homework0922.Student;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 王旻爽
 * 2020/9/22
 * @ClassName StudentTest.java
 */
public class StudentTest {

    public static void main(String[] args) {

        // 创建学生List
        List<Student> studentList = new ArrayList<>(6);
        // 添加学生对象
        studentList.add(new Student("10010","小李",98));
        studentList.add(new Student("10011","小鹏",88));
        studentList.add(new Student("10012","小王",91));
        studentList.add(new Student("10013","小马",74));
        studentList.add(new Student("10014","小周",54));
        studentList.add(new Student("10015","小刘",64));
        // 遍历集合
        for (Student student : studentList) {
            System.out.println(student);
        }

        // 创建一个学生对象查看集合中是否存在
        if(studentList.contains(new Student("10014","小王",55))){
            System.out.println("存在！！");
        } else {
            System.out.println("不存在！");
        }

        // 遍历集合查看是否存在分数低于60分的同学
        studentList.removeIf(next -> next.getScore() < 60);

        // 遍历集合
        for (Student student : studentList) {
            System.out.println(student);
        }
    }

}
