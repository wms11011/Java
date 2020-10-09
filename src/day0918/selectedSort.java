package day0918;

/**
 * @author 王旻爽
 * 2020/9/18
 * @ClassName selectedSort.java
 */
public class selectedSort {

    public static void main(String[] args) {
        // 初始化数组
        int[] data = new int[100];
        for(int i=0;i<data.length;i++){
            double dd = Math.random();
            int x = (int) (dd*100);
            data[i] = x;
        }
        // 遍历数组
        for (int datum : data) {
            System.out.print(datum+"  ");
        }
        System.out.println();

        // 使用选择排序对数组进行排序
        int[] ss = Sort(data);

        System.out.println("-----------以下是排序的结果---------------");
        for (int s : ss) {
            System.out.print(s+"  ");
        }
    }

    private static int[] Sort(int[] data) {

        for (int j = 0; j < data.length-1; j++) {
            int min = j;  // 保存最小元素下标
            for (int i = min+1; i < data.length; i++) {
                if(data[min] > data[i]){
                    min = i;
                }
            }
                int temp = data[j];
                data[j] = data[min];
                data[min] = temp;
        }
        return data;
    }
}
