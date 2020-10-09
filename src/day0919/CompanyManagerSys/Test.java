package day0919.CompanyManagerSys;

/**
 * @author 王旻爽
 * 2020/9/19
 * @ClassName Test.java
 */
public class Test {

    public static void main(String[] args) {

        // 创建公司
        // 添加10名员工
        int size = 10;
        CompanyManager companyManager = new Company("1011","NEC",size);
        System.out.println("-----------------------添加10名员工------------------------");
        companyManager.insertEmployee("10010","小王",21,3600);
        companyManager.insertEmployee("10011","小李",25,5800);
        companyManager.insertEmployee("10012","小张",23,7900);
        companyManager.insertEmployee("10013","小周",28,6500);
        companyManager.insertEmployee("10014","小明",30,7800);
        companyManager.insertEmployee("10015","小红",22,2100);
        companyManager.insertEmployee("10016","小锋",24,3400);
        companyManager.insertEmployee("10017","小刘",26,8800);
        companyManager.insertEmployee("10018","小兰",27,1430);
        companyManager.insertEmployee("10019","小娟",32,9900);


        // 显示所有员工信息
        System.out.println("-----------------------显示所有员工信息-----------------------");
        companyManager.showAllInformation();

        // 按年龄升序排序
        System.out.println("------------------------按年龄升序排序-----------------------");
        companyManager.sortByAge();
        companyManager.showAllInformation();

        // 按工资降序排序
        System.out.println("------------------------按工资降序排序-----------------------");
        companyManager.sortBySalary();
        companyManager.showAllInformation();

        // 是否存在{id=10019，name=小娟}的员工
        System.out.println("------------------是否存在{id=10019，name=小娟}的员工-----------");
        if(companyManager.isExist("10019","小娟")){

            System.out.println("存在！！");
        } else {
            System.out.println("不存在！！");
        }

        // 删除{id=10019，name=小娟}这名员工
        System.out.println("------------------删除{id=10019，name=小娟}这名员工------------");
        if(companyManager.deleteEmployee("10019","小娟")){

            System.out.println("删除成功！！");
            // 再次显示员工信息
            companyManager.showAllInformation();
        } else {
            System.out.println("删除失败，该员工不存在！！");
        }
    }
}
