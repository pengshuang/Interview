package test;

/**
 * Created by pengshuang on 17/7/30.
 */
public class TwoKeysKeyboard {
    public static int minSteps(int n) {
        int[] dp = new int[n+1];

        for (int i = 2; i <= n; i++) {
            dp[i] = i;
            for (int j = i-1; j > 1; j--) {
                if (i % j == 0) {
                    dp[i] = dp[j] + (i/j);
                    break;
                }

            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(minSteps(9));
    }
}
