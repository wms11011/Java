package day0919.restaurant;

/**
 * @author 王旻爽
 * 2020/9/19
 * @ClassName AmericaCooker.java
 */
public class AmericaCooker implements FoodMenu {
    @Override
    public void makeHamburger() {
        System.out.println("请美国厨师做汉堡！！");
    }

    @Override
    public void makeNoodles() {
        System.out.println("请美国厨师做意大利面！！！");
    }
}
