package day0919.Bird;

/**
 * @author 王旻爽
 * 2020/9/19
 * @ClassName Slingshot.java
 */
public class Slingshot {

    Flyable flyable;

    public Slingshot(Flyable flyable) {
        this.flyable = flyable;
    }

    public Flyable getFlyable() {
        return flyable;
    }

    public void setFlyable(Flyable flyable) {
        this.flyable = flyable;
    }

    public void shoot(Flyable flyable){
        flyable.fly();
    }
}
