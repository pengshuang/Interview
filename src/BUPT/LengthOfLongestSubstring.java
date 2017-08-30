package BUPT;

/**
 * Created by pengshuang on 17/8/30.
 */
public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {

        int[] dp = new int[256];
        int i = 0, j = 0;
        int res = 0;
        while (j < s.length()) {
            if (dp[s.charAt(j)] == 0){
                dp[s.charAt(j)] = 1;
                j++;
                res = Math.max(res, j - i);
            } else {
                dp[s.charAt(i)] = 0;
                i++;
            }
        }
        return res;

    }

}
