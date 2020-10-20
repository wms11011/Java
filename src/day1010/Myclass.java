package day1010;

/**
 * @author 王旻爽
 * 2020/10/10
 * @ClassName Myclass.java
 */
public class Myclass {
    public int x;
    private int y;

    public Myclass() {
    }

    public Myclass(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "Myclass{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
