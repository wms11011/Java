package homework0921;

/**
 * @author 王旻爽
 * 2020/9/21
 * @ClassName StudentTest.java
 */
public class StudentTest {

    public static void main(String[] args) {

        String s1 = "1001,lisi,98;2002,wanwu,75;3003,chenqi,86;4004,feifei,66";

        String[] stu = s1.split("[,;]");
        Student[] stu1 = new Student[stu.length / 3];
        int size = 0;
        for (int i = 0; i < stu.length; i = i + 3) {
            stu1[size++] = new Student(stu[i],stu[i+1],Integer.parseInt(stu[i+2]));
        }
        for (int i = 0; i < stu1.length; i++) {
            Student student = stu1[i];
            System.out.println(student.toString());
        }

    }
}
