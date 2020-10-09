package day0919.restaurant;

/**
 * @author 王旻爽
 * 2020/9/19
 * @ClassName Customer.java
 */
public class Customer {

    FoodMenu foodMenu;

    public Customer(FoodMenu foodMenu) {
        this.foodMenu = foodMenu;
    }

    public FoodMenu getFoodMenu() {
        return foodMenu;
    }

    public void setFoodMenu(FoodMenu foodMenu) {
        this.foodMenu = foodMenu;
    }

    public void order(FoodMenu foodMenu){
        foodMenu.makeHamburger();
        foodMenu.makeNoodles();
    }
}
