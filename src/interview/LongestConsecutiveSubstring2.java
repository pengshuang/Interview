package interview;

/**
 * Created by pengshuang on 17/2/16.
 * 最长公共子串
 */

public class LongestConsecutiveSubstring2 {
    public static int[][] getdp(char[] str1, char[] str2){
        int[][] dp = new int[str1.length][str2.length];
        for (int i = 0; i < str1.length; i++) {
            if (str1[i] == str2[0]) {
                dp[i][0] = 1;
            }
        }
        for (int i = 0; i < str2.length; i++) {
            if (str1[0] == str2[i]) {
                dp[0][i] = 1;
            }
        }
        for (int i = 1; i < str1.length; i++) {
            for (int j = 1; j < str2.length; j++) {
                if (str1[i] == str2[j]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
            }
        }
        return dp;
    }

    public static String lcst1(String str1, String str2) {
        if (str1 == null || str2 == null || str1.equals("") || str2.equals("")){
            return "";
        }
        char[] ch1 = str1.toCharArray();
        char[] ch2 = str2.toCharArray();
        int[][] dp = getdp(ch1, ch2);
        int end = 0;
        int max = 0;
        for (int i = 0; i < ch1.length; i++) {
            for (int j = 0; j < ch2.length; j++) {
                if (dp[i][j] > max) {
                    end = i;
                    max = dp[i][j];
                }
            }
        }
        return str1.substring(end - max + 1, end + 1);
    }

    public static String lcst2(String str1, String str2) {
        if (str1 == null || str2 == null || str1.equals("") || str2.equals("")){
            return "";
        }
        char[] ch1 = str1.toCharArray();
        char[] ch2 = str2.toCharArray();
        int row = 0;
        int col = ch2.length - 1;
        int max = 0;
        int end = 0;
        while (row < ch1.length) {
            int i = row;
            int j = col;
            int len = 0;
            while (i < ch1.length && j < ch2.length) {
                if (ch1[i] != ch2[j]){
                    len = 0;
                } else {
                    len++;
                }
                if (len > max){
                    end = i;
                    max = len;
                }
                i++;
                j++;
            }
            if (col > 0) {
                col--;
            } else {
                row++;
            }
        }
        return str1.substring(end - max + 1, end + 1);
    }

    public static void main(String [] args){
        String a = "abc12";
        String b = "ebc2kh";
        System.out.println(lcst2(a, b));
    }

}
