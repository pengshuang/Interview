package interview;

/**
 * Created by pengshuang on 17/2/10.
 * 1. 换钱的最少货币数(货币可以重复)
 * 2. 换钱的最少货币数(货币不可以重复)
 */
public class MinCoins {
    public static int minCoins(int[] arr, int aim) {
        if (arr == null || arr.length == 0 || aim < 0) {
            return -1;
        }
        int n = arr.length;
        int max = Integer.MAX_VALUE;
        int[][] dp = new int[n][aim + 1];
        for (int j = 1; j <= aim; j++) {
            dp[0][j] = max;
            if (j - arr[0] >= 0 && dp[0][j - arr[0]] != max) {
                dp[0][j] = dp[0][j - arr[0]] + 1;
            }
        }
        int left = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= aim; j++) {
                left = max;
                if (j - arr[i] >= 0 && dp[i][j - arr[i]] != max) {
                    left = dp[i][j - arr[i]] + 1;
                }
                dp[i][j] = Math.min(left, dp[i - 1][j]);
            }
        }
        return dp[n - 1][aim] != max ? dp[n - 1][aim] : -1;
    }

    public static int minCoins2(int[] arr, int aim) {
        if (arr == null || arr.length == 0 || aim < 0) {
            return -1;
        }
        int n = arr.length;
        int max = Integer.MAX_VALUE;
        int[][] dp = new int[n][aim + 1];
        for (int j = 1; j <= aim ; j++) {
            dp[0][j] = max;
        }
        if (arr[0] <= aim) {
            dp[0][arr[0]] = 1;
        }
        int leftup = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= aim; j++) {
                leftup = max;
                if (j - arr[i] >= 0 && dp[i - 1][j - arr[i]] != max) {
                    leftup = dp[i - 1][j - arr[i]] + 1;
                }
                dp[i][j] = Math.min(leftup, dp[i - 1][j]);
            }
        }
        return dp[n - 1][aim] != max ? dp[n - 1][aim] : -1;
    }

    public static void main(String args[]) {
        System.out.println(minCoins(new int[]{1,2,3}, 7));
    }
}
