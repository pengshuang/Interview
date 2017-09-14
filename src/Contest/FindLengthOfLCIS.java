package Contest;

/**
 * Created by pengshuang on 17/9/10.
 */
public class FindLengthOfLCIS {
    public static int findLengthOfLCIS(int[] nums) {
        if (nums.length == 0)
            return 0;
        int res = 0;
        for (int i = 0 ; i < nums.length; i++) {
            int temp = 1;
            int start = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] > nums[start]) {
                    temp++;
                    start++;
                } else {
                    break;
                }
            }
            res = Math.max(res, temp);
        }
        return res;
    }
    public static void main(String [] args) {
        int[] nums = new int[] {2,2,2,2};
        System.out.println(findLengthOfLCIS(nums));
    }
}
