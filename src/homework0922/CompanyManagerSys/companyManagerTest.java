package homework0922.CompanyManagerSys;

import day0919.CompanyManagerSys.Employee;

import java.util.Iterator;
import java.util.List;

/**
 * @author 王旻爽
 * 2020/9/22
 * @ClassName companyManagerTest.java
 */
public class companyManagerTest {

    public static void main(String[] args) {

        company NEC = new company("101454578","NEC");

        // 添加员工信息
        NEC.insertEmployees(new Employee("10010","小王",21,3600));
        NEC.insertEmployees(new Employee("10011","小李",25,5800));
        NEC.insertEmployees(new Employee("10012","小张",23,7900));
        NEC.insertEmployees(new Employee("10013","小周",28,6500));
        NEC.insertEmployees(new Employee("10014","小明",30,7800));
        NEC.insertEmployees(new Employee("10015","小红",22,2100));
        NEC.insertEmployees(new Employee("10016","小锋",24,3400));
        NEC.insertEmployees(new Employee("10017","小刘",26,8800));
        NEC.insertEmployees(new Employee("10018","小兰",27,1430));
        NEC.insertEmployees(new Employee("10019","小娟",32,9900));

        // 显示所有员工信息
        System.out.println("-----------------------显示所有员工信息-----------------------");
        NEC.showALL();

        // 按年龄升序排序
        System.out.println("------------------------按年龄升序排序-----------------------");
        List<Employee> byAge = NEC.sortByAge(NEC.getEmployeeList());
        for (Employee next : byAge) {
            System.out.println(next);
        }

        // 按工资降序排序
        System.out.println("------------------------按工资降序排序-----------------------");
        List<Employee> bySalary = NEC.sortBySalary(NEC.getEmployeeList());
        for (Employee next : bySalary) {
            System.out.println(next);
        }
        // 删除{id=10019，name=小娟}的员工
        System.out.println("------------------删除{id=10019，name=小娟}的员工-----------");
        boolean b = NEC.deleteEmployees(new Employee("10019", "小娟", 32, 9900));
        if(b){

            System.out.println("删除成功！！");
            // 再次显示员工信息
            NEC.showALL();
        } else {
            System.out.println("删除失败，该员工不存在！！");
        }
    }
}
