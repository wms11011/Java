package homework0923;

import java.util.*;

/**
 * @author 王旻爽
 * 2020/9/23
 * @ClassName course.java
 */
public class course {

    public static void main(String[] args) {

        Map<String,String> courseMap = new HashMap<>();

        courseMap.put("小李","语文");
        courseMap.put("小张","数学");
        courseMap.put("小王","英语");
        courseMap.put("小刘","体育");
        courseMap.put("小金","劳动");
        courseMap.put("小红","音乐");
        courseMap.put("小娟","物理");

        System.out.println(courseMap);

         // 判断是否开设了体育课
        if(courseMap.containsValue("体育")){
            System.out.println("开设了体育课！！");
        } else {
            System.out.println("没有开设体育课！！");
        }

        // 查看音乐课的教师
        String teacher = null;
        Set<Map.Entry<String,String>> set = courseMap.entrySet();
        Iterator<Map.Entry<String,String>> iterator = set.iterator();
        for (Map.Entry<String, String> next : set) {
            if (next.getValue() == "音乐") {
                teacher = next.getKey();
            }
        }

        System.out.println("音乐老师是"+teacher);

        // 判断feifei老师是否有任教课程
        if(courseMap.containsKey("菲菲")){
            System.out.println("有菲菲老师任教的课程");
        } else {
            System.out.println("没有菲菲老师任教的课程");
        }


        for (Map.Entry<String, String> next : set) {
            if (next.getValue() == "体育") {
                teacher = next.getKey();
            }
        }

        // 把体育课的老师更换为”dudu”
        courseMap.put("老杜",courseMap.remove(teacher));
        System.out.println(courseMap);

        // 删除劳动课
        for (Map.Entry<String, String> next : set) {
            if (next.getValue() == "劳动") {
                teacher = next.getKey();
            }
        }

        courseMap.remove(teacher);
        System.out.println(courseMap);
    }
}
