package interview;

import java.util.Scanner;

public class ConstructHW {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            String str = in.nextLine();
            String str1 = " " + str;
            char[] ch = str1.toCharArray();
            char[] ch1 = new char[ch.length];
            int k = 1;
            ch1[0] = ' ';
            for (int i=ch.length-1;i>0;i--){
                ch1[k++] = ch[i];
            }
            int len = str.length() - getMax(ch, ch1);
            System.out.println(len);
        }
    }

    private static int getMax(char[] ch, char[] ch1){
        int[][] dp = new int[ch.length][ch1.length];
        for (int i=0;i<ch.length;i++){
            dp[0][i] = 0;
        }
        for (int i=0;i<ch1.length;i++){
            dp[i][0] = 0;
        }
        for (int i=1;i<ch.length;i++){
            for (int j=1;j<ch.length;j++){
                if(ch[i]==ch1[j])
                    dp[i][j] = dp[i-1][j-1] + 1;
                else
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }
        return dp[ch.length-1][ch.length-1];
    }
}
