package day0918;

/**
 * @author 王旻爽
 * 2020/9/18
 * @ClassName arrayDelete.java
 */
public class arrayDelete {
    public static void main(String[] args) {

        // 定义一个初始数组
        int[] data = {12,55,65,98,74,15,23};

        // 使用delete方法删除第四个位置上的元素
        data = delete(data,4);
        for (int datum : data) {
            System.out.print(datum + " ");

        }
    }

    private static int[] delete(int[] data, int i) {

        // 定义一个小的数组-
        int[] array = new int[data.length-1];

        // 把数组data第i个元素之前的数据复制到array中
        System.arraycopy(data,0,array,0,i);

        // 再把data数组第[i+1,data.length）的数据复制到array中
        System.arraycopy(data,i,array,i-1,data.length-i);
        // 返回数组
        return array;
    }


}
