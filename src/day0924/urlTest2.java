package day0924;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 王旻爽
 * 2020/9/24
 * @ClassName urlTest2.java
 */
public class urlTest2 {

    public static void main(String[] args) {

        String urlParameter = "name=Jack&gender=male&interests=basketball&interests=score&interests=friend";
        Map<String, String[]> map = new HashMap<>();
        String[] str = urlParameter.split("[&=]");
        for (int i = 0; i < str.length; i+=2) {
            if(!map.containsKey(str[i])){
                map.put(str[i],new String[]{str[i+1]});
            } else {
                String[] strings = map.get(str[i]);
                String[] strings1 = Arrays.copyOf(strings, strings.length + 1);
                strings1[strings.length-1] = str[i+1];
                map.replace(str[i],strings1);
            }
        }

        for (Map.Entry<String, String[]> stringEntry : map.entrySet()) {
            System.out.println(stringEntry.getKey() +  "------->" + Arrays.toString(stringEntry.getValue()));
        }
    }
}
