package homework0925;

import java.util.*;

/**
 * @author 王旻爽
 * 2020/9/26
 * @ClassName porkerTest.java
 */
public class porkerTest {

    // 存储花色
    private static List<String> color = new ArrayList<>(4);

    // 存储点数
    private static List<String> num = new ArrayList<>(15);

    // 玩家1
    private static List<Integer> player1 = new ArrayList<>(20);

    // 玩家2
    private static List<Integer> player2 = new ArrayList<>(20);

    // 玩家3
    private static List<Integer> player3 = new ArrayList<>(20);

    // 存放底牌
    private static List<Integer> bottom = new ArrayList<>(3);

    // 存放唯一编号
    private static List<Integer> number = new ArrayList<>(54);

    // 每张牌的唯一编号
    private static int index;

    // 一个随机数，用于选出地主
    private static int master;

    // 建立牌库
    private static Map<Integer,String> card = new HashMap<>(54);

    public static void main(String[] args) {

        new porkerTest();
    }

    private porkerTest() {

        color.add("♠");
        color.add("♥");
        color.add("♦");
        color.add("♣");

        num.add("3");
        num.add("4");
        num.add("5");
        num.add("6");
        num.add("7");
        num.add("8");
        num.add("9");
        num.add("10");
        num.add("J");
        num.add("Q");
        num.add("K");
        num.add("A");
        num.add("2");

        sortCard();
        riffle();
        threePlayers();
        look();
    }

    // 为每一张牌按点数和花色排序，并给每一张牌一个唯一的编号index，将
    // 编号作为key，牌作为value，并同时将编号存入List中
    private static void sortCard(){

        // 按花色和点数顺序将牌放入牌库
        for (String s : color) {
            for (String s1 : num) {
                card.put(index,s+s1);
                number.add(index);
                index++;
            }
        }


        // 存入小王
        card.put(index,"小王");
        number.add(index);
        index++;

        // 存入大王
        card.put(index,"大王");
        number.add(index);
        index++;

    }

    // 洗牌后选出一张地主牌，同时取出三张底牌
    private static void riffle(){

        // 洗牌
        Collections.shuffle(number);

        // 取出三张底牌
        bottom.add(number.get(51));
        bottom.add(number.get(52));
        bottom.add(number.get(53));

        // 在剩余的牌中随机选出一张牌作为地主牌
        master = new Random().nextInt(51);
    }

    // 给三位玩家发牌，抽到地主牌的玩家成为地主，并将三张底牌也发给地主
    private static void threePlayers(){
        // 底牌取出后给每位玩家发牌
        for (int i = 0; i < number.size() - 3; i++) {
            if(i%3==0){
                player1.add(number.get(i));
            }
            if(i%3==1){
                player2.add(number.get(i));
            }
            if(i%3==2){
                player3.add(number.get(i));
            }
        }

        // 抽到地主牌的玩家成为地主，并将三张底牌发给地主
        for (int i = 0; i < player1.size(); i++) {
            if(player1.get(i).equals(number.get(master))){
                player1.addAll(bottom);
            }
        }
        for (int i = 0; i < player2.size(); i++) {
            if(player2.get(i).equals(number.get(master))){
                player2.addAll(bottom);
            }
        }
        for (int i = 0; i < player3.size(); i++) {
            if(player3.get(i).equals(number.get(master))){
                player3.addAll(bottom);
            }
        }

        // 对三位玩家手中的牌进行排序
        Collections.sort(player1);
        Collections.sort(player2);
        Collections.sort(player3);
        Collections.sort(bottom);

    }

    // 看牌
    private static void look(){

        // 玩家1
        System.out.println("玩家1的牌是：");
        for (Integer integer : player1) {
            System.out.print(card.get(integer)+" ");
        }
        if (player1.size() == 20){
            System.out.println();
            System.out.println("玩家1是地主");
        }
        System.out.println();

        System.out.println("玩家2的牌是：");
        for (Integer integer : player2) {
            System.out.print(card.get(integer)+" ");
        }
        if (player2.size() == 20){
            System.out.println();
            System.out.println("玩家2是地主");
        }
        System.out.println();

        System.out.println("玩家3的牌是：");
        for (Integer integer : player3) {
            System.out.print(card.get(integer)+" ");
        }
        if (player3.size() == 20){
            System.out.println();
            System.out.println("玩家3是地主");
        }
        System.out.println();

        System.out.println("底牌是：");
        for (Integer integer : bottom) {
            System.out.print(card.get(integer)+" ");
        }
        System.out.println();

        System.out.println("地主牌是：");
        System.out.println(card.get(master));

    }
}
