package interview;

/**
 * Created by pengshuang on 17/2/16.
 */
public class MaximumProductSubarray {
    public static int maxProduct(int[] nums) {
        int[] max = new int[nums.length];
        int[] min = new int[nums.length];

        min[0] = max[0] = nums[0];
        int result = nums[0];

        for (int i = 1; i < nums.length; i++){
            min[i] = max[i] = nums[i];
            if(nums[i] > 0){
                max[i] = Math.max(max[i], max[i - 1]*nums[i]);
                min[i] = Math.min(min[i], min[i - 1]*nums[i]);
            } else if (nums[i] < 0){
                max[i] = Math.max(max[i], min[i - 1]*nums[i]);
                min[i] = Math.min(min[i], max[i - 1]*nums[i]);
            }
            result = Math.max(result, max[i]);
        }
        return result;
    }

    public static void main(String [] args) {
        System.out.println(maxProduct(new int[]{1,-2,3,4}));
    }
}
