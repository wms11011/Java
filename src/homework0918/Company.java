package homework0918;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;

/**
 * @author 王旻爽
 * 2020/9/18
 * @ClassName Company.java
 */
public class Company {

    // 公司名称
    private String companyName;

    // 公司代码
    private String kgNo;

    // 员工
    private employee[] employees;

    public Company() {
    }

    public Company(String companyName, String kgNo, employee[] employees) {
        this.companyName = companyName;
        this.kgNo = kgNo;
        this.employees = employees;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getKgNo() {
        return kgNo;
    }

    public void setKgNo(String kgNo) {
        this.kgNo = kgNo;
    }

    public employee[] getEmployees() {
        return employees;
    }

    public void setEmployees(employee[] employees) {
        this.employees = employees;
    }

    // 显示所有员工信息
    public void showAllInformation(){
        for (employee employees: this.getEmployees()) {
            if(employees == null){
                continue;
            }
            System.out.println(employees.toString());
        }
    }

    // 判断是否存在某员工
    public boolean isExist(employee e){
        for (int i = 0; i < this.getEmployees().length; i++) {
            if (this.getEmployees()[i].equals(e)){
                return true;
            }
        }
        return false;
    }

    // 删除某位员工
    public boolean deleteEmployee(String name,int age,double salary){

        employee e = new employee(name,age,salary);

        // 先判断是否存在该员工
        if(!isExist(e)){
            return false;
        }

        // 确认该员工的索引值
        int index = 0;
        for (int i = 0; i < this.getEmployees().length; i++) {
            if (this.getEmployees()[i].equals(e)){
                index = i;
                break;
            }
        }
        // 删除该员工
        System.arraycopy(this.getEmployees(),index+1,this.getEmployees(),index,this.getEmployees().length-index-1);
        this.getEmployees()[this.getEmployees().length-1] = null;
        return true;
    }

    // 按员工年龄升序排序
    public employee[] sortByAge(employee[] e){

        int fromIndex = 0;
        int toIndex = 10;
        Arrays.sort(e,fromIndex,toIndex,new Comparator<employee>(){

            @Override
            public int compare(employee o1, employee o2) {
                //根据人的年龄升序排序, o1的年龄大返回正数, 相等返回0, o1年龄小返回负数
                if ( o1.getAge() > o2.getAge()) {
                    return 1;
                }else if ( o1.getAge() == o2.getAge()) {
                    return 0;
                }else {
                    return -1;
                }
            }
        });

        return e;
    }

    // 按员工工资降序排序
    public employee[] sortBySalary(employee[] e){

        int fromIndex = 0;
        int toIndex = 10;
        Arrays.sort(e,fromIndex,toIndex, new Comparator<employee>() {
            @Override
            public int compare(employee o1, employee o2) {
                if ( o1.getSalary() > o2.getSalary()) {
                    return -1;
                }else if ( o1.getSalary() == o2.getSalary()) {
                    return 0;
                }else {
                    return 1;
                }
            }
        });

        return e;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Company)) return false;
        Company company = (Company) o;
        return companyName.equals(company.companyName) &&
                kgNo.equals(company.kgNo) &&
                Arrays.equals(employees, company.employees);
    }

    @Override
    public int hashCode() {
        return Objects.hash(companyName, kgNo);
    }

    @Override
    public String toString() {
        return "Company{" +
                "公司名称='" + companyName + '\'' +
                ", 公司代码='" + kgNo + '\'' +
                '}';
    }
}
