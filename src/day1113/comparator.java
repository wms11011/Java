package day1113;

/**
 * @author 王旻爽
 * 2020/11/13
 * @ClassName comparator.java
 */
public class comparator {

    public static <T extends Comparable> compare<T> calculate(T[] array){

        T min = array[0];
        T max = array[0];
        if (array == null || array.length == 0){
            return null;
        }
        if(array.length == 1){
            min = array[0];
            max = array[0];
        }
        for (int i = 1; i <array.length ; i++) {
            if(min.compareTo(array[i]) > 0){
                min = array[i];
            }
            if(max.compareTo(array[i]) < 0){
                max = array[i];
            }
        }

        return new compare<>(max,min);
    }

    @Override
    public String toString() {
        return "comparator{}";
    }
}
