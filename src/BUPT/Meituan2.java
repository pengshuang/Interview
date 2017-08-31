package BUPT;

import java.util.Arrays;
import java.util.Scanner;

public class Meituan2 {

    public static void main(String [] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
        }
        Arrays.sort(nums);
        if (judge(nums))
            System.out.println("Yes");
        else
            System.out.println("No");

    }

    public static boolean judge(int[] nums) {
        int max = nums[nums.length - 1];
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if (sum >= 2 * max)
            return true;
        else
            return false;
    }
}
