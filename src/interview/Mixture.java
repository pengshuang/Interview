package interview;

/**
 * Created by pengshuang on 17/2/21.
 */
public class Mixture {
    public static boolean chkMixture(String A, int n, String B, int m, String C, int v) {
        if (n + m != v){
            return false;
        }
        boolean[][] dp = new boolean[n + 1][m + 1];
        dp[0][0] = true;
        for (int i = 1; i <= m; i++) {
            if (B.charAt(i - 1) == C.charAt(i - 1))
                dp[0][i] = true;
            else
                break;
        }
        for (int i = 1; i <= n; i++) {
            if (A.charAt(i - 1) == C.charAt(i - 1))
                dp[i][0] = true;
            else
                break;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (!dp[i][j]) {
                    if (dp[i - 1][j] && A.charAt(i - 1) == C.charAt(i + j - 1))
                        dp[i][j] = true;
                    if (dp[i][j - 1] && B.charAt(j - 1) == C.charAt(i + j - 1))
                        dp[i][j] = true;
                }
            }
        }
        return dp[n][m];
    }

    public static void main(String [] args) {
        String a = "bcbccabccacccbcac";
        String b = "abbbacaabccbccaaaabbcbcbaaacccbaaba";
        String c = "babbbacaabccbccaaaabbcbcbaaacccbaabacbccabccacccbcac";
        System.out.println(chkMixture(a, 17, b, 35, c, 52));
    }
}
