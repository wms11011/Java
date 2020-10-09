package homework0923;

import java.util.*;

/**
 * @author 王旻爽
 * 2020/9/23
 * @ClassName QQ.java
 */
public class QQ {

    public static void main(String[] args) {

        // 定义存储QQ号的数组
        String[] qqArray = {"23323", "45343", "334554","23323", "23323", "23323", "23323"};

        // 将数组转为List集合
        ArrayList<String> qqList = new ArrayList<>(Arrays.asList(qqArray));

        // 定义HashMap
        Map<String,Integer> hashMap = new HashMap<>();

        // 返回某重复元素第一次出现在数组中的索引值并在List中删除重复的元素
        for (int i = 0; i < qqArray.length; i++) {
            if(!hashMap.containsKey(qqArray[i])){
                hashMap.put(qqArray[i],i);
                continue;
            }
        }

        // 遍历输出List

        Set<String> stringSet = new HashSet<>(hashMap.keySet());
        for (String s : stringSet) {
            System.out.println(s);
        }

    }
}
