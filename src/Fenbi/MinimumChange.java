package Fenbi;

/**
 * Created by pengshuang on 17/9/14.
 */
public class MinimumChange {
    public static void main(String [] args) {
        int[] nums = new int[]{5,4,3,2,1};
        System.out.println(count(nums));
    }

    static int count(int[] nums) {
        int n = nums.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (i+1 == nums[i])
                continue;
            else {
                while (nums[i] != i + 1) {
                    swap(nums, i, nums[i] - 1);
                    count++;
                }
            }
        }
        return count;
    }

    static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
