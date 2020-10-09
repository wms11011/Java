package LeetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 王旻爽
 * 2020/9/20
 * @ClassName TwoSum.java
 */
public class TwoSum {
    public static void main(String[] args) {

        int[] data = {2,8,5,7,9};
        System.out.println(Arrays.toString(TwoSum.twoSumOfArray(data,9)));
    }

    public static int[] twoSumOfArray(int[] nums, int target) {
        int n = nums.length;
        int[] data = new int[2];
        int sum = (n * n - n) / 2;
        for (int i = 0; i < n; i++) {
            for (int j = nums.length - 1; j > i; j--) {
                if (nums[i] + nums[j] == target) {
                    data[0] = i;
                    data[1] = j;
                    return data;
                }
            }
        }
        return data;
    }
}
