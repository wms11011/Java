package homework0923;

import java.util.*;

/**
 * @author 王旻爽
 * 2020/9/23
 * @ClassName lottery.java
 */
public class lottery {

    public static void main(String[] args) {

        Integer [] redBall = redBallNum();

        int blueBall = blueBallNum();

        System.out.println("红色球号码为：");
        for (Integer integer : redBall) {
            System.out.println(integer);
        }
        System.out.println("蓝色球的号码为："+blueBall);

    }

    private static int blueBallNum() {

        Random random = new Random();
        int i = random.nextInt(17);
        if(i == 0){
            return i+1;
        }
        return i;
    }

    private static Integer[] redBallNum() {
        Integer[] a = new Integer[6];
        Set<Integer> integerSet =  new HashSet<>();
        Random random = new Random();
        while(integerSet.size() < 6){
            int i = random.nextInt(34);
            if(!integerSet.contains(i)){
                if(i == 0){
                    integerSet.add(i+1);
                }
                integerSet.add(i);
            }
        }
        return integerSet.toArray(a);
    }


}
