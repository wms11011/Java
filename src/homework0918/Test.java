package homework0918;

/**
 * @author 王旻爽
 * 2020/9/18
 * @ClassName Test.java
 */
public class Test {

    public static void main(String[] args) {

        // 初始化员工信息
        int size = 0;
        employee[] employees = new employee[10];
        employees[size++] = new employee("小王",21,3600);
        employees[size++] = new employee("小李",25,5800);
        employees[size++] = new employee("小张",23,7900);
        employees[size++] = new employee("小周",28,6500);
        employees[size++] = new employee("小明",30,7800);
        employees[size++] = new employee("小红",22,2100);
        employees[size++] = new employee("小锋",24,3400);
        employees[size++] = new employee("小刘",26,8800);
        employees[size++] = new employee("小兰",27,1430);
        employees[size++] = new employee("小娟",32,9900);

        // 初始化公司信息(初始化时即可添加员工信息)
        Company company = new Company("NEC","6558975421",employees);

        // 显示所有员工信息
        System.out.println("-------显示所有员工信息----------");
        company.showAllInformation();

        // 判断是否存在某员工
        System.out.println("-------判断是否存在某员工(小娟)----------");
        employee e = new employee("小娟",32,9900);
        if(company.isExist(e)){
            System.out.println("存在");
        } else {
            System.out.println("不存在");
        }

        // 按年龄升序排序
        System.out.println("-------按年龄升序排序----------");
        employee[] data = company.sortByAge(employees);
        for (int i = 0; i < data.length; i++) {
            System.out.println(data[i].toString());
        }

        // 按工资降序排序
        System.out.println("-------按工资降序排序----------");
        employee[] data2 = company.sortBySalary(employees);
        for (int i = 0; i < data2.length; i++) {

            System.out.println(data2[i].toString());
        }

        // 删除某位员工
        System.out.println("-------删除某位员工(小李)----------");
        if(company.deleteEmployee("小李",25,5800)){
            System.out.println("删除成功！！");
        } else {
            System.out.println("删除失败！！");
        }

        // 再显示所有员工信息
        System.out.println("-------再显示所有员工信息----------");
        company.showAllInformation();

    }
}
