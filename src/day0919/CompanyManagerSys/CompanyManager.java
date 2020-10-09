package day0919.CompanyManagerSys;

/**
 * @author 王旻爽
 * 2020/9/19
 * @ClassName CompanyManager.java
 */
public interface CompanyManager {

    // 显示所有员工信息
    public void showAllInformation();

    // 判断是否存在某员工
    public boolean isExist(String Id, String name);

    // 添加一位员工
    public void insertEmployee(String Id, String name, int age, double salary);

    // 删除某位员工
    public boolean deleteEmployee(String Id, String name);

    // 按员工年龄升序排序
    public void sortByAge();

    // 按员工工资降序排序
    public void sortBySalary();

}
