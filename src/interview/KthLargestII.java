package interview;

import java.util.PriorityQueue;

/**
 * Created by pengshuang on 17/8/29.
 */
public class KthLargestII {
    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0)
            return 0;
        return helper(nums, 0, nums.length - 1, nums.length - k + 1);
    }

    public int partition(int[] nums, int left, int right) {
        int pivot = nums[left];
        while (left < right) {
            while (left < right && nums[right] >= pivot) {
                right--;
            }
            nums[left] = nums[right];
            while (left < right && nums[left] <= pivot) {
                left++;
            }
            nums[right] = nums[left];
        }
        nums[left] = pivot;
        return left;
    }

    public int helper(int[] nums, int start, int end, int k) {
        int pos = partition(nums, start, end);
        if (pos + 1 == k)
            return nums[pos];
        if (pos + 1 < k)
            return helper(nums, pos + 1, end, k);
        else
            return helper(nums, start, pos - 1, k);
    }
}
