package day0918;

/**
 * @author 王旻爽
 * 2020/9/18
 * @ClassName binarySearch.java
 */
public class binarySearch {

    public static void main(String[] args) {

        int [] data = {11,22,33,44,55,66,77};

        System.out.println( binarySearchImpl(data, 11));
        System.out.println( binarySearchImpl(data, 55));
        System.out.println( binarySearchImpl(data, 77));
        System.out.println( binarySearchImpl(data, 99));
    }

    private static int binarySearchImpl(int[] data, int key) {

        int from = 0;
        int to = data.length-1;
        int mid = (from + to) / 2;
        while(from <= to){
            if(data[mid] == key){
                return mid;
            } else if (data[mid] > key){
                to = mid-1;
                mid = (from + to) / 2;
            } else {
                from = mid +1;
                mid = (from + to) / 2;
            }
        }
        return -1;
    }
}
