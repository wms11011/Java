package day0919.restaurant;

/**
 * @author 王旻爽
 * 2020/9/19
 * @ClassName Test.java
 */
public class Test {

    public static void main(String[] args) {

        FoodMenu foodMenu = new ChineseCooker();

        foodMenu.makeNoodles();

        foodMenu.makeHamburger();
    }
}
