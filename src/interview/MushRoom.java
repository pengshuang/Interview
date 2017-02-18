package interview;

import java.util.Scanner;

/**
 * Created by pengshuang on 17/2/18.
 */
public class MushRoom {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            int m = in.nextInt();
            int k = in.nextInt();
            boolean[][] map = new boolean[n][m];
            for (int i = 0; i < k; i++) {
                int x = in.nextInt() - 1;
                int y = in.nextInt() - 1;
                map[x][y] = true;
            }
            double p = getRoutes(map, n, m);
            System.out.println(String.format("%.2f", p));
        }
    }

    public static double getRoutes(boolean[][] map, int n, int m){

        double[][] dp=new double[n][m];//dp[][]记录从起点到坐标为（x,y）的概率
        dp[0][0]=1;
        for(int i=1;i<m;i++){
            dp[0][i] = map[0][i]?0:dp[0][i-1]*(n==1?1:0.5);
        }
        for(int i=1;i<n;i++){
            dp[i][0] = map[i][0]?0:dp[i-1][0]*(m==1?1:0.5);
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (i == n-1 && j == m-1){
                    dp[i][j] = map[i][j] ? 0:dp[i-1][j] + dp[i][j-1];
                } else if (i == n-1){
                    dp[i][j] = map[i][j] ? 0:dp[i-1][j]*0.5 + dp[i][j-1];
                } else if (j == m-1){
                    dp[i][j] = map[i][j] ? 0:dp[i-1][j] + dp[i][j-1] * 0.5;
                } else {
                    dp[i][j] = map[i][j] ? 0:dp[i-1][j] * 0.5 + dp[i][j-1] * 0.5;
                }
            }
        }
        return dp[n-1][m-1];
    }
}
