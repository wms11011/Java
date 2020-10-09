package day0919.CompanyManagerSys;

import java.util.Objects;

/**
 * @author 王旻爽
 * 2020/9/19
 * @ClassName Employee.java
 */
public class Employee {

    // Id
    private String id;

    // 姓名
    private String name;

    // 年龄
    private int age;

    // 工资
    private double salary;

    public Employee() {
    }

    public Employee(String id, String name, int age, double salary) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public Employee(String id, String name) {
        this.id = id;
        this.name = name;
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
    public String toString() {
        return "Employee{" +
                "id='" + id + '\'' +
                ", 姓名='" + name + '\'' +
                ", 年龄=" + age +
                ", 工资=" + salary +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;
        Employee employee = (Employee) o;
        return id.equals(employee.id) &&
                name.equals(employee.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age, salary);
    }
}
