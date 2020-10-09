package day0924;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @author 王旻爽
 * 2020/9/24
 * @ClassName carHashMap.java
 */
public class carHashMap {

    public static void main(String[] args) {

        Map<String,String> carMap = new HashMap<>(10);

        // 添加10条记录
        carMap.put("红旗","小李");
        carMap.put("丰田","小王");
        carMap.put("本田","小红");
        carMap.put("奔驰","小刘");
        carMap.put("宝马","小川");
        carMap.put("宾利","小马");
        carMap.put("大众","小军");
        carMap.put("现代","小金");
        carMap.put("林肯","小孔");
        carMap.put("尼桑","小明");

        // 判断是否存在某个Car对象
        if(carMap.containsKey("现代")){
            System.out.println("存在！！！");
        } else {
            System.out.println("不存在！！");
        }

        // 判断宾利的车主是谁
        String s = carMap.get("宾利");
        System.out.println("宾利的车主是 :" + s);


        // 判断小刘是否有车
        Set<Map.Entry<String,String>> set = carMap.entrySet();
        for (Iterator<Map.Entry<String, String>> iterator = set.iterator(); iterator.hasNext(); ) {
            Map.Entry<String, String> next =  iterator.next();
            if(next.getValue() == "小刘" && next.getKey() != null){
                System.out.println("小刘有车！！");
                 continue;
            }
        }

        // 删除丰田汽车
        String s1 = carMap.remove("丰田");
        System.out.println("已删除丰田汽车！！");
        System.out.println(carMap);

        // 将林肯的车主换为李四
        String replace = carMap.replace("宾利", "李四");
        System.out.println("已将宾利的车主" + replace + "替换为李四");
        System.out.println(carMap);
    }


}
