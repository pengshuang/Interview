package interview;

import java.util.Scanner;

/**
 * Created by pengshuang on 17/2/16.
 */
public class Fenpingguo {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++){
            nums[i] = in.nextInt();
        }
        System.out.println(avg(nums));
    }

    private static int avg(int[] nums){
        int sum = 0;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            sum += nums[i];
        }
        int avg = sum / len;
        if (sum%len != 0){
            return -1;
        }
        for (int i = 0; i < len; i++) {
            int t = Math.abs(nums[i] - avg);
            if(t%2 !=0){
                return -1;
            }
        }
        int index = 0;
        for (int i = 0; i < len; i++) {
            if(nums[i] > avg){
                index += (Math.abs(nums[i] - avg)/2);
            }
        }
        return index;
    }
}
