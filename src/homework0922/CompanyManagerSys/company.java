package homework0922.CompanyManagerSys;

import day0919.CompanyManagerSys.Employee;
import homework0921.Student;

import java.util.*;

/**
 * @author 王旻爽
 * 2020/9/22
 * @ClassName company.java
 */
public class company {

    // 企业代码
    private String kgNo;

    // 企业名称
    private String kgName;


    // 员工List
    private List<Employee> employeeList = new ArrayList<>(100);

    public company() {
    }

    public company(String kgNo, String kgName) {
        this.kgNo = kgNo;
        this.kgName = kgName;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof company)) return false;
        company company = (company) o;
        return Objects.equals(kgNo, company.kgNo) &&
                Objects.equals(kgName, company.kgName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(kgNo, kgName, employeeList);
    }

    @Override
    public String toString() {
        return "company{" +
                "企业代码='" + kgNo + '\'' +
                ", 企业名称='" + kgName + '\'' +
                '}';
    }

    public String getKgNo() {
        return kgNo;
    }

    public void setKgNo(String kgNo) {
        this.kgNo = kgNo;
    }

    public String getKgName() {
        return kgName;
    }

    public void setKgName(String kgName) {
        this.kgName = kgName;
    }


    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    // 添加一位员工
    public boolean insertEmployees(Employee e){

        // 先判断该员工是否存在
        if(getEmployeeList().contains(e)){
            return false;
        }

        // 添加该员工信息
        getEmployeeList().add(e);
        return true;
    }

    // 删除一位员工
    public boolean deleteEmployees(Employee e){

        // 先判断该员工是否存在
        if(!getEmployeeList().contains(e)){
            return false;
        }

        // 删除员工信息
        getEmployeeList().remove(e);
        return true;
    }

    // 显示所有员工信息
    public void showALL(){
        for (Iterator<Employee> iterator = employeeList.iterator(); iterator.hasNext(); ) {
            Employee next =  iterator.next();
            System.out.println(next);
        }
    }

    // 所有员工按年龄升序排序
    public List<Employee> sortByAge(List<Employee> list){

        list.sort(new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return o1.getAge() - o2.getAge();
            }
        });

        return list;
    }

    // 判断是否存在某姓名的员工
    public boolean containsName(String name){
        if(name != null){
            for (int i = 0; i < getEmployeeList().size(); i++) {
                if(getEmployeeList().get(i).getName() == name){
                    return true;
                }
            }
        } else {
            for (int i = 0; i < getEmployeeList().size(); i++) {
                if(getEmployeeList().get(i).getName() == null){
                    return true;
                }
            }
        }

        return false;
    }

    // 所有员工按工资降序排序
    public List<Employee> sortBySalary(List<Employee> list){

        list.sort(new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return Double.compare(o2.getSalary(),o1.getSalary());
            }
        });

        return list;
    }
}
