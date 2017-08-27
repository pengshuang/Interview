package BUPT;

import java.util.Scanner;

public class Test360 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int[] num1 = new int[m];
        for (int i = 0; i < m; i++) {
            num1[i] = sc.nextInt();
        }
        int res = getSum(num1) - 2 * diff(num1);
        System.out.println(res);

    }

    static int diff(int[] nums) {
        int sum = getSum(nums);
        int[][] dp = new int[nums.length + 1][sum/2 + 1];
        for (int i = 1; i <= nums.length; i++) {
            for (int j = 1; j <= sum/2; j++) {
                if (j >= nums[i - 1])
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-nums[i-1]] + nums[i-1]);
            }
        }
        return dp[nums.length][sum/2];
    }

    static int getSum(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res += nums[i];
        }
        return res;
    }

}