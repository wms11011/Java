package day0919.CompanyManagerSys;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;

/**
 * @author 王旻爽
 * 2020/9/19
 * @ClassName Company.java
 */
public class Company implements CompanyManager {

    // 企业代码
    private String kgNo;

    // 企业名称
    private String kgName;

    // 企业员工
    private Employee employee;

    // 数组容量
    private int size;

    // 企业员工List
    private Employee[] employeesList;

    public Company(String kgNo, String kgName, Employee employee, Employee[] employeesList) {
        this.kgNo = kgNo;
        this.kgName = kgName;
        this.employee = employee;
        this.employeesList = employeesList;
    }

    public Company(String kgNo, String kgName, Employee[] employeesList) {
        this.kgNo = kgNo;
        this.kgName = kgName;
        this.employeesList = employeesList;
    }

    public Company(String kgNo, String kgName,int size) {
        if(size > 0){
            employeesList = new Employee[size];
        } else {
            employeesList = new Employee[100];
        }
        this.kgNo = kgNo;
        this.kgName = kgName;
    }

    public Company() {
        employeesList = new Employee[100];
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

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Employee[] getEmployeesList() {
        return employeesList;
    }

    public void setEmployeesList(Employee[] employeesList) {
        this.employeesList = employeesList;
    }

    @Override
    public String toString() {
        return "Company{" +
                "kgNo='" + kgNo + '\'' +
                ", kgName='" + kgName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Company)) return false;
        Company company = (Company) o;
        return kgNo.equals(company.kgNo) &&
                kgName.equals(company.kgName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(kgNo, kgName);
    }

    @Override
    /**
     * 显示所有员工信息
     */
    public void showAllInformation() {

        for (Employee employees : employeesList) {

            if(employees == null){
                continue;
            }
            System.out.println(employees.toString());
        }
    }

    @Override
    /**
     * 判断是否存在某员工
     */
    public boolean isExist(String Id, String name) {

        if(Id != null && name != null){
            for (int i = 0; i < employeesList.length; i++) {

                if(employeesList[i].equals(new Employee(Id,name))){
                    return true;
                }
            }
        } else {
                for (int i = 0; i < employeesList.length; i++) {
                    if(employeesList[i].getId() == null || employeesList[i].getName() == null){
                        return true;
                    }
                }
        }
        return false;
    }

    @Override
    /**
     * 添加一位员工
     */
    public void insertEmployee(String Id, String name,int age,double salary) {

        // 先判断数组是否有足够的容量
        if(size == employeesList.length){
            int newCapacity = size + (size>>1);
            Arrays.copyOf(employeesList,newCapacity);
        }

        employeesList[size++] = new Employee(Id,name,age,salary);
    }

    @Override
    /**
     * 删除某位员工
     */
    public boolean deleteEmployee(String Id, String name) {


        // 判断员工表是否为空
        if(employeesList.length == 0 || employeesList == null){
            return false;
        }

        // 判断是否存在该员工
        if(!isExist(Id,name)){
            return false;
        }

        // 确认该员工的索引值
        int index = indexEmployee(Id,name);


        // 删除该员工
        System.arraycopy(employeesList.length,index+1,employeesList.length,index,employeesList.length-index-1);
        this.getEmployeesList()[this.getEmployeesList().length-1] = null;
        return true;
    }



    @Override
    /**
     * 按员工年龄升序排序
     */
    public void sortByAge() {

        int fromIndex = 0;
        int toIndex = size;
        Arrays.sort(employeesList, fromIndex, toIndex, new Comparator<Employee>() {

            @Override
            public int compare(Employee o1, Employee o2) {
                //根据人的年龄升序排序, o1的年龄大返回正数, 相等返回0, o1年龄小返回负数
                if (o1.getAge() > o2.getAge()) {
                    return 1;
                } else if (o1.getAge() == o2.getAge()) {
                    return 0;
                } else {
                    return -1;
                }
            }
        });
    }

    @Override
    /**
     * 按员工工资降序排序
     */
    public void sortBySalary(){

        int fromIndex = 0;
        int toIndex = size;
        Arrays.sort(employeesList,fromIndex,toIndex, new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                if ( o1.getSalary() > o2.getSalary()) {
                    return -1;
                }else if ( o1.getSalary() == o2.getSalary()) {
                    return 0;
                }else {
                    return 1;
                }
            }
        });
    }

    /**
     * 确定某员工的索引值
     *
     * @param Id 员工ID
     * @param name 员工姓名
     * @return 索引值
     */
    private int indexEmployee(String Id, String name){
        if(Id != null && name != null){
            for (int i = 0; i < employeesList.length; i++) {

                if(employeesList[i].equals(new Employee(Id,name))){
                    return i;
                }
            }
        } else {
            for (int i = 0; i < employeesList.length; i++) {
                if(employeesList[i].getId() == null || employeesList[i].getName() == null){
                    return i;
                }
            }
        }
        return -1;
    }
}
