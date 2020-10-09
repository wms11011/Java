package homework0923;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 王旻爽
 * 2020/9/23
 * @ClassName StringTest.java
 */
public class StringTest {

    public static void main(String[] args) {

        // 定义字符串变量
        String str = "djklajadskljfaklsjfakljfkajfkajskfljasklfjaklsjfaskljfakljdalfskj";

        Map<Character,Integer> strMap = new HashMap<>();

        for (int i = 'a'; i <= 'z'; i++) {
            strMap.put((char) i,0);
        }

        for (int i = 0; i < str.length(); i++) {
            if(strMap.containsKey(str.charAt(i))){
                int i1 = strMap.get(str.charAt(i));
                i1 = i1 +1;
                strMap.replace(str.charAt(i),i1);
            }
        }

        System.out.println(strMap);

        }
    }

