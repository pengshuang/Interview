/**
 * Created by pengshuang on 17/9/14.
 */
public class FindDuplicates {
    static int findDuplicate(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left + 1 < right) {
            int pos = (left + right) / 2;
            if (nums[pos] == pos)
                right = pos;
            else
                left = pos;
        }
        return nums[right];
    }

    public static void main(String [] args) {
        int[] nums = new int[]{1,1};
        System.out.println(findDuplicate(nums));
    }
}
