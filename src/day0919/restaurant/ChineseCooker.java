package day0919.restaurant;

/**
 * @author 王旻爽
 * 2020/9/19
 * @ClassName ChineseCooker.java
 */
public class ChineseCooker implements FoodMenu {

    @Override
    public void makeHamburger() {
        System.out.println("请中国厨师做汉堡！！");
    }

    @Override
    public void makeNoodles() {

        System.out.println("请中国厨师做牛肉面！！！");
    }
}
