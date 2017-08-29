package BUPT;

/**
 * Created by pengshuang on 17/8/27.
 */
public class ChangeCoins {
    static int solve(int[] coins, int m) {
        int[][] dp = new int[coins.length + 1][m + 1];
        for (int i = 0; i <= coins.length; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= coins.length; i++) {
            for (int j = 0; j <= m; j++) {
                dp[i][j] = dp[i-1][j];
                if (j >= coins[i-1])
                    dp[i][j] += dp[i][j-coins[i-1]];
            }
        }
        return dp[coins.length][m];
    }

    public static void main(String[] args) {
        int[] coins = new int[]{1, 3, 5, 7};
        int m = 3;
        System.out.println(solve(coins, m));
    }
}
