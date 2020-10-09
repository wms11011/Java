package homework0922;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author 王旻爽
 * 2020/9/22
 * @ClassName IntList.java
 */
public class IntList {

    public static void main(String[] args) {

        List<Integer> integerList = new ArrayList<>(20);
        for (int i = 0; i < 20; i++) {
            double d = Math.random();
            int random = (int) (d*100);
            if(integerList.contains(random)){
                i--;
                continue;
            }
            integerList.add(random);
        }

        // 判断是否存在66
        if(integerList.contains(66)){
            System.out.println("存在！！");
        } else {
            System.out.println("不存在！！");
        }


        integerList.removeIf(next -> next == 66);

        for (Integer integer : integerList) {
            System.out.println(integer);
        }

    }
}
