package homework0924.weather;

import java.util.*;

/**
 * @author 王旻爽
 * 2020/9/25
 * @ClassName weatherTest.java
 */
public class weatherTest {

    public static void main(String[] args) {
        Map<String,String> weatherMap1 = new HashMap<>();
        weatherMap1.put("date","今天（周三）");
        weatherMap1.put("weather","多云");
        weatherMap1.put("wind","微风");
        weatherMap1.put("temperature","23℃");

        Map<String,String> weatherMap2 = new HashMap<>();
        weatherMap2.put("date","明天（周四）");
        weatherMap2.put("weather","雷阵雨转中雨");
        weatherMap2.put("wind","微风");
        weatherMap2.put("temperature","29～22℃");

        Map<String,String> weatherMap3 = new HashMap<>();
        weatherMap3.put("date","后天（周五）");
        weatherMap3.put("weather","阴转多云");
        weatherMap3.put("wind","微风");
        weatherMap3.put("temperature","31～23℃");

        Map<String,String> weatherMap4 = new HashMap<>();
        weatherMap4.put("date","大后天（周六）");
        weatherMap4.put("weather","多云");
        weatherMap4.put("wind","微风");
        weatherMap4.put("temperature","31～24℃");

        List<Map<String,String>> list = new ArrayList<>();

        Collections.addAll(list,weatherMap1,weatherMap2,weatherMap3,weatherMap4);

        Map<String,String> map = new HashMap<>();

        System.out.println("[\n");
        for (int i = 0; i < list.size(); i++) {
            map = list.get(i);
            System.out.println("\t{");
            for (Map.Entry<String, String> stringStringEntry : map.entrySet()) {
                System.out.println("\t\t"+stringStringEntry.getKey() + ":" + stringStringEntry.getValue());
            }
            System.out.println("\t}");
        }
        System.out.println("]\n");
    }
}
