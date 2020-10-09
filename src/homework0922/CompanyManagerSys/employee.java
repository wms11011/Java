package homework0922.CompanyManagerSys;

import java.util.Objects;

/**
 * @author 王旻爽
 * 2020/9/22
 * @ClassName employee.java
 */
public class employee {

    // 姓名
    private String name;

    // 年龄
    private int age;

    // 工资
    private double salary;

    public employee() {
    }

    public employee(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof employee)) return false;
        employee employee = (homework0922.CompanyManagerSys.employee) o;
        return age == employee.age &&
                Double.compare(employee.salary, salary) == 0 &&
                name.equals(employee.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, salary);
    }

    @Override
    public String toString() {
        return "employee{" +
                "姓名='" + name + '\'' +
                ", 年龄='" + age + '\'' +
                ", 工资=" + salary +
                '}';
    }
}
