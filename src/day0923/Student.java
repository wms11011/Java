package day0923;

import java.util.Objects;

/**
 * @author 王旻爽
 * 2020/9/22
 * @ClassName Student.java
 */
public class Student implements Comparable<Student>{

    // 学号
    private String id;

    // 姓名
    private String name;

    // 成绩
    private int score;

    public Student() {
    }

    public Student(String id, String name, int score) {
        this.id = id;
        this.name = name;
        this.score = score;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "学号='" + id + '\'' +
                ", 姓名='" + name + '\'' +
                ", 成绩=" + score +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        Student student = (Student) o;
        return score == student.score &&
                Objects.equals(id, student.id) &&
                Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, score);
    }

    @Override
    public int compareTo(Student o) {
        int score = getScore();
        int anotherScore = o.getScore();
        return score - anotherScore;
    }
}
