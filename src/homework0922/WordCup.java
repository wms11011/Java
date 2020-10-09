package homework0922;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * @author 王旻爽
 * 2020/9/22
 * @ClassName WordCup.java
 */
public class WordCup {
    static int aa;
    public static void main(String[] args) {

        String[] team = {"中国", "意大利", "德国", "法国", "俄罗斯", "西班牙", "阿根廷", "巴西", "新加坡", "越南", "泰国", "印度", "韩国", "日本", "尼日利亚", "朝鲜"};
        List<String> teamList = new ArrayList<>(16);
        teamList = Arrays.asList(team);
        Integer[] i1 = randomNum();
        System.out.println("A组：");
        for (int i = 1; i <= 16; i++) {

            System.out.println(teamList.get(i1[i-1]));
            if(i%4 == 0){
                System.out.println();
                if(i != 16){
                    int integer = Integer.valueOf('A' + ++aa);
                    System.out.println( (char) integer+ "组：");
                }
            }
        }

    }

    // 生成0~15的不重复随机数
    private static Integer[] randomNum(){

        List<Integer> integerList = new ArrayList<>(20);
        Random random = new Random();
        for (int i = 0; i < 16; i++) {
            int i1 = random.nextInt(16);
            if(integerList.contains(i1)){
                i--;
                continue;
            }
            integerList.add(i1);
        }
        Integer[] integers = new Integer[16];
        return integerList.toArray(integers);
    }
}
