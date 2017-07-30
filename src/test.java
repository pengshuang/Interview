import java.util.*;

public class test {

    public static void main(String [] args){
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            int n = in.nextInt();
            long k = in.nextLong();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = in.nextInt();
            }
            int[] res = helper(nums, k);
            for (int i = 0; i < res.length - 1; i++) {
                System.out.print(res[i] + " ");
            }
            System.out.println(res[res.length - 1]);
        }
    }

    private static int[] helper(int[] nums, long k){
        int length = nums.length;
        while (k > 0){
            int temp = nums[0];
            for (int i = 0; i < length - 1; i++) {
                nums[i] = (nums[i] + nums[i + 1])%100;

            }
            nums[length - 1] = (nums[length - 1] + temp)%100;
            k -= 1;

        }
        return nums;
    }
}
