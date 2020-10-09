package homework0924.userLogin;

import java.util.*;

/**
 * @author 王旻爽
 * 2020/9/24
 * @ClassName admin.java
 */
public class admin {

    // 定义一个存储用户信息的map
    static Map<String,String> UserMap = new HashMap<>();


    public static void main(String[] args) {

        while (true) {
            switch (selectFunction(showMainPage())) {
                case 1 :
                    System.out.println("注册成功！！");
                    continue;
                case 2 :
                    System.out.println("该用户已存在！！");
                    continue;
                case 3 :
                    System.out.println("登录成功！！");
                    continue;
                case 4 :
                    System.out.println("登录失败！！");
            }
        }

    }

    private static int showMainPage(){
        System.out.println("-------------------------主界面-----------------------------------");
        System.out.println("1 注册          2  登录            3 退出");
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入你的操作：");
        int i = sc.nextInt();
        return i;
    }

    // 用户注册功能
    private int register(){

        System.out.println("=*=*=*=*=*=*=*=*=*=*=*用户注册界面=*=*=*=*=*=*=*=*=*=*=*=*=*=*");
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入用户名：");
        String username = sc.next();
        System.out.println("请输入密码  ：");
        String password = sc.next();
        if (!UserMap.containsKey(username)) {
            UserMap.put(username,password);
            return 1;
        } else {
            return 2;
        }

    }

    // 用户登录
    private int signIn(){

        System.out.println("=*=*=*=*=*=*=*=*=*=*=*用户登录界面=*=*=*=*=*=*=*=*=*=*=*=*=*=*");
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入用户名：");
        String userName = sc.next();
        System.out.println("请输入密码  ：");
        String password = sc.next();
        Set<Map.Entry<String,String>> set = UserMap.entrySet();
        if(userName != null && password != null){
            for (Map.Entry<String, String> entry : set) {
                if(entry.getKey() .equals(userName)  && entry.getValue().equals(password)){
                    return 3;
                }
            }
        }

        return 4;
    }

    private static int selectFunction(int code){
        admin admin = new admin();
        switch (code) {
            case 1 :
                return admin.register();
            case 2 :
                return admin.signIn();
            case 3 :
                 exit();
            default:
                return showMainPage();
        }
    }

    // 退出系统
    private static void exit(){
        System.exit(0);
    }
}
