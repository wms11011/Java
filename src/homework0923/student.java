package homework0923;

import java.io.Serializable;
import java.util.Objects;

/**
 * @author 王旻爽
 * 2020/9/23
 * @ClassName student.java
 */
public class student implements Serializable {

    private static final long serialVersionUID = -1104536440171496147L;

    private String stuId;

    private int grade;

    private int score;

    public student() {
    }

    public student(String stuId, int grade, int score) {
        this.stuId = stuId;
        this.grade = grade;
        this.score = score;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof student)) return false;
        student student = (student) o;
        return Objects.equals(stuId, student.stuId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(stuId, grade, score);
    }

    @Override
    public String toString() {
        return "student{" +
                "stuId='" + stuId + '\'' +
                ", grade=" + grade +
                ", score=" + score +
                '}';
    }

    public String getStuId() {
        return stuId;
    }

    public void setStuId(String stuId) {
        this.stuId = stuId;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
