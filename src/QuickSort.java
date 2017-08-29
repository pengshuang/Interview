import java.util.Arrays;

/**
 * Created by pengshuang on 17/8/29.
 */
public class QuickSort {
    public static void quickSort(int[] nums, int left, int right) {
        if (nums == null || nums.length == 0)
            return;
        if (left < right) {
            int index = partition(nums, left, right);
            quickSort(nums, left, index-1);
            quickSort(nums, index+1, right);
        }
    }

    public static int partition(int[] nums, int left, int right) {
        int pivot = nums[left];
        while (left < right) {
            while (left < right && nums[right] >= pivot)
                right--;
            nums[left] = nums[right];
            while (left < right && nums[left] <= pivot)
                left++;
            nums[right] = nums[left];
        }
        nums[left] = pivot;
        return left;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,3,4,5,2,7,3,1,9,1,1,1};
        quickSort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }
}
