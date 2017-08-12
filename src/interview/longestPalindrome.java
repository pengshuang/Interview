package interview;

/**
 * Created by pengshuang on 17/8/12.
 */
public class longestPalindrome {
    public int longestPalindrome(String s) {
        int length = s.length();
        if (length == 0)
            return 0;
        int[][] dp = new int[length][length];
        for (int i = length - 1; i >= 0; i--) {
            dp[i][i] = 1;
            for (int j = i+1; j < length; j++) {
                if (s.charAt(i) == s.charAt(j))
                    dp[i][j] = dp[i+1][j-1] + 2;
                else
                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
            }
        }
        return dp[0][length-1];
    }
}
