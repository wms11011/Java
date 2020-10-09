package day0917;

/**
 * @author 王旻爽
 * 2020/9/17
 * @ClassName ArrayTest.java
 */
public class ArrayTest {
    public static void main(String[] args) {

        // 初始化数组，数组长度为随机值。
        double dd = Math.random();
        int data1 = (int) (dd * 10);
        int[] data = CreateArray(data1);
        // 在控制台上打印数组中的内容
        printArray(data);
    }

    /**
     * 初始化数组。
     *
     * @param capacity 数组容量
     * @return int[]
     */
    private static int[] CreateArray(int capacity){

        int[] data = new int[capacity];
        for (int i = 0; i < data.length; i++) {
            double dd = Math.random();
            int data1 = (int) (dd * 100);
            data[i] = data1;
        }

        return data;
    }

    /**
     * 在控制台上打印数组中的内容。
     *
     * @param a 需要打印的数组
     */
    private static void printArray(int[] a){
        for (int value : a) {
            System.out.print(value + "  ");
        }
    }

}
