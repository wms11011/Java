package FinalTest.eCommercePlatform;

import javax.crypto.spec.PSource;
import java.sql.SQLOutput;
import java.util.*;

/**
 * @author 王旻爽
 * 2020/10/2
 * @ClassName admin.java
 */
public class admin {

    // 存储用户信息
    static Map<String,String> UserMap = new HashMap<>();

    // 存储商品信息
    static Map<String,Goods> goodsMap = new TreeMap<>();

    public static void main(String[] args) {

        while (true) {
            switch (selectFunction(showMainPage())) {

                case 2 :
                    System.out.println("注册成功！！");
                    continue;
                case 3 :
                    System.out.println("该用户已存在！！");
                    continue;
                case 4 :
                    System.out.println("登录成功！！");
                    adminManager();
                    continue;
                case 5 :
                    System.out.println("登录失败！！");
                default:
                    showMainPage();
            }
        }
    }

    /**
     * 显示主界面
     */
    private static int showMainPage(){
        System.out.println("-------------------------主界面-----------------------------------");
        System.out.println("1,浏览所有商品         2，注册             3，登录          4，退出");
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入你的操作：");
        int i = sc.nextInt();
        return i;
    }

    /**
     * 浏览所有商品
     */
    private static void showAllGoods(){
        System.out.println("-------------------------商品信息-----------------------------------");
        System.out.println("商品编号      商品名称      商品价格     商品销量");
        if(goodsMap == null){
            System.out.println("还没有添加商品！！");
            showMainPage();
        } else {
            for (Map.Entry<String, Goods> entry : goodsMap.entrySet()) {
                System.out.println(entry.getValue());
            }
        }
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
            return 2;
        } else {
            return 3;
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
                    return 4;
                }
            }
        }
        return 5;
    }

    // 排序
    private static void sort(){

        System.out.println("请选择排序方式 ：   1，名称升序    2，价格升序    3，销量降序");
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入你的操作：");
        int index = sc.nextInt();
        List<Map.Entry<String,Goods>> list = new ArrayList<>(goodsMap.entrySet());
        System.out.println("商品编号      商品名称      商品价格     商品销量");
        if(index == 1){
            list.sort(new Comparator<Map.Entry<String, Goods>>() {
                @Override
                public int compare(Map.Entry<String, Goods> o1, Map.Entry<String, Goods> o2) {
                    return o1.getValue().getGoodsName().compareTo(o2.getValue().getGoodsName());
                }
            });
            for (Map.Entry<String, Goods> entry : list) {
                System.out.println(entry.getValue());
            }
        } else if(index == 2){
            list.sort(new Comparator<Map.Entry<String, Goods>>() {
                @Override
                public int compare(Map.Entry<String, Goods> o1, Map.Entry<String, Goods> o2) {
                    return Double.compare(o1.getValue().getGoodsPrice(),o2.getValue().getGoodsPrice());
                }
            });
            for (Map.Entry<String, Goods> entry : list) {
                System.out.println(entry.getValue());
            }
        } else {
            list.sort(new Comparator<Map.Entry<String, Goods>>() {
                @Override
                public int compare(Map.Entry<String, Goods> o1, Map.Entry<String, Goods> o2) {
                    return o2.getValue().getGoodsSellVolume()-o1.getValue().getGoodsSellVolume();
                }
            });
            for (Map.Entry<String, Goods> entry : list) {
                System.out.println(entry.getValue());
            }
        }

    }


    private static void adminManager(){
        System.out.println("=========================产品管理操作界面=============================");
        System.out.println("1,显示所有商品\n2,添加商品\n3,删除商品\n4,修改商品\n5,查找商品");
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入你的操作：");
        int index = sc.nextInt();
        if(index == 1){
            showAllGoods();
        } else if(index == 2){
            System.out.println("请输入商品编号：");
            String goodesNum = sc.next();
            System.out.println("请输入商品名称：");
            String goodsName = sc.next();
            System.out.println("请输入商品价格:");
            int goodsPrice = sc.nextInt();
            System.out.println("请输入商品销量：");
            int goodsSellVolume = sc.nextInt();
            if(goodesNum != null){
                goodsMap.put(goodesNum,new Goods(goodesNum,goodsName,goodsPrice,goodsSellVolume));
            } else {
                System.out.println("输入有误！！");
            }
        } else if(index == 3){
            System.out.println("请输入商品编号：");
            String goodesNum = sc.next();
            Goods remove = goodsMap.remove(goodesNum);
            if(remove == null){
                System.out.println("删除失败！！");
            }
        } else if(index == 4){
            System.out.println("请输入新的商品编号：");
            String goodesNum = sc.next();
            System.out.println("请输入新的商品名称：");
            String goodsName = sc.next();
            System.out.println("请输入新的商品价格:");
            int goodsPrice = sc.nextInt();
            System.out.println("请输入新的商品销量：");
            int goodsSellVolume = sc.nextInt();
            goodsMap.replace(goodesNum,new Goods(goodesNum,goodsName,goodsPrice,goodsSellVolume));
        } else if(index == 5){
            System.out.println("请输入商品编号：");
            String goodesNum = sc.next();
            System.out.println("商品编号      商品名称      商品价格     商品销量");
            System.out.println(goodsMap.get(goodesNum));
        }

    }

    private static int selectFunction(int code){
        admin admin = new admin();
        switch (code) {
            case 1 :
                showAllGoods();
                sort();
                break;
            case 2 :
                return admin.register();
            case 3 :
                return admin.signIn();
            case 4 :
                exit();
            default:
                return showMainPage();
        }
        return 1;
    }

    // 退出系统
    private static void exit(){
        System.exit(0);
    }
}
