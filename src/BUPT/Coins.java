package BUPT;

/**
 * Created by pengshuang on 17/8/31.
 * 台阶数为 m, 一共能走 n 步
 */
public class Coins {
    public static int[][] count(int[] a, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        dp[0][0] = 0;
        dp[1][1] = a[0];
        for (int i = 2; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = Math.max(dp[i-2][j-1] + a[i-1],
                                    dp[i-1][j-1] + a[i-1]);
            }
        }
        return dp;
    }

    public static void main(String[] args) {
        int[] a = new int[]{3,2,1};
        int[][] res = count(a, 3, 2);
        int max = 0;
        for (int i = 0; i < res.length; i++) {
            max = Math.max(max, res[i][2]);
        }
        System.out.println(max);
    }
}
