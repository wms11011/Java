package day0923;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * @author 王旻爽
 * 2020/9/23
 * @ClassName test.java
 */
public class test {

    public static void main(String[] args) {

        TreeSet<Student> treeSet = new TreeSet<>(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getScore() - o2.getScore();
            }
        });

        System.out.println("在TreeSet构造方法中重写Comparator完成排序");
        treeSet.add(new Student("10010","小李",98));
        treeSet.add(new Student("10011","小鹏",88));
        treeSet.add(new Student("10012","小王",91));
        treeSet.add(new Student("10013","小马",74));
        treeSet.add(new Student("10014","小周",54));

        for (Student next : treeSet) {
            System.out.println(next);

        }

        System.out.println();
        System.out.println("Student类实现Comparable接口重写compareTo()方法");
        TreeSet<Student> treeSet1 = new TreeSet<>();
        treeSet1.add(new Student("10010","小李",98));
        treeSet1.add(new Student("10011","小鹏",88));
        treeSet1.add(new Student("10012","小王",91));
        treeSet1.add(new Student("10013","小马",74));
        treeSet1.add(new Student("10014","小周",54));

        for (Student next : treeSet1) {
            System.out.println(next);
        }
    }
}
