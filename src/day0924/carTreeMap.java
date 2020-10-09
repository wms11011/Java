package day0924;

import java.util.Map;
import java.util.TreeMap;

/**
 * @author 王旻爽
 * 2020/9/24
 * @ClassName carTreeMap.java
 */
public class carTreeMap {

    public static void main(String[] args) {

        TreeMap<Car,String> carMap = new TreeMap<>();
        carMap.put(new Car("红旗"),"小李");
        carMap.put(new Car("丰田"),"小王");
        carMap.put(new Car("本田"),"小红");
        carMap.put(new Car("奔驰"),"小刘");
        carMap.put(new Car("宝马"),"小川");
        carMap.put(new Car("宾利"),"小马");
        carMap.put(new Car("大众"),"小军");
        carMap.put(new Car("现代"),"小金");
        carMap.put(new Car("林肯"),"小孔");
        carMap.put(new Car("尼桑"),"小明");

        // 输出
        for (Map.Entry<Car, String> carStringEntry : carMap.entrySet()) {
            System.out.println(carStringEntry);
        }

    }
}
