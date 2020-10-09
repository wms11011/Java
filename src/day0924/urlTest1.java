package day0924;

import java.util.*;

/**
 * @author 王旻爽
 * 2020/9/24
 * @ClassName Test.java
 */
public class urlTest1 {

    public static void main(String[] args) {
        String urlParameter = "name=Jack&gender=male&interests=basketball&interests=score&interests=friend";
        Map<String,List<String>> map = new HashMap<>();
        String[] str = urlParameter.split("[&=]");
        for (int i = 0; i < str.length; i += 2) {
            if(!map.containsKey(str[i])){
                List<String> list = new ArrayList<>();
                list.add(str[i+1]);
                map.put(str[i],list);
            } else {
                List<String> list = map.get(str[i]);
                list.add(str[i+1]);
            }
        }

        for (Map.Entry<String, List<String>> stringListEntry : map.entrySet()) {
            System.out.println(stringListEntry);
        }
    }
}
