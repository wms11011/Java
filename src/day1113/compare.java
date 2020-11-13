package day1113;

/**
 * @author 王旻爽
 * 2020/11/13
 * @ClassName compare.java
 */
public class compare<T> {

    private T max;
    private T min;

    public compare() {
    }

    public compare(T max, T min) {
        this.max = max;
        this.min = min;
    }

    @Override
    public String toString() {
        return "compare{" +
                "max=" + max +
                ", min=" + min +
                '}';
    }

    public T getMax() {
        return max;
    }

    public void setMax(T max) {
        this.max = max;
    }

    public T getMin() {
        return min;
    }

    public void setMin(T min) {
        this.min = min;
    }
}
