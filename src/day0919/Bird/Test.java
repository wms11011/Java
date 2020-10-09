package day0919.Bird;

/**
 * @author 王旻爽
 * 2020/9/19
 * @ClassName Test.java
 */
public class Test {

    public static void main(String[] args) {

        Flyable flyable = new RedBird();
        flyable.fly();

        Flyable flyable1 = new BlackBird();
        flyable1.fly();

        Flyable flyable2 = new BlueBird();
        flyable2.fly();

        Flyable flyable3 = new YellowBird();
        flyable3.fly();
    }
}
