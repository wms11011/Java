package LeetCode.练习;

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

    /**
     *给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
     *
     * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
     *
     * 示例:
     *
     * 给定 nums = [2, 7, 11, 15], target = 9
     *
     * 因为 nums[0] + nums[1] = 2 + 7 = 9
     * 所以返回 [0, 1]
     *
     */
    private static int[] twoSumOfArray(int[] nums, int target) {
        int n = nums.length;
        int[] data = new int[2];
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

    public int[] twoSumOfHashMap(int[] nums, int target) {
        int[] data = new int[2];
        Map<Integer, Integer> hash = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int tmp = target - nums[i];
            if(hash.containsKey(tmp)){
                data[0] = hash.get(tmp);
                data[1] = i;
            }
            hash.put(nums[i],i);
        }
        return data;
    }
}
