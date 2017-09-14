import java.util.Scanner;

public class Main2 {
    public static void main(String [] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            int n = in.nextInt();
            int m = in.nextInt();
            int[][] nums = new int[n][m];
            int x = in.nextInt();
            int y = in.nextInt();
            int x1 = in.nextInt();
            int y1 = in.nextInt();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    nums[i][j] = in.nextInt();
                    if (nums[i][j] == 2) {
                        nums[i][j] = 1;
                        if ((i-1 > 0 && i-1 < n) && (j-1 > 0 && j-1 < n))
                            nums[i-1][j-1] = 1;
                        if ((i+1 > 0 && i+1 < n) && (j+1 > 0 && j+1 < n))
                            nums[i+1][j+1] = 1;
                        if ((i+1 > 0 && i+1 < n) && (j-1 > 0 && j-1 < n))
                            nums[i+1][j-1] = 1;
                        if ((i-1 > 0 && i-1 < n) && (j+1 > 0 && j+1 < n))
                            nums[i-1][j+1] = 1;
                    } else  if (nums[i][j] == 3) {
                        nums[i][j] = 1;
                        if ((i-1 > 0 && i-1 < n) && (j-1 > 0 && j-1 < n))
                            nums[i-1][j-1] = 1;
                        if ((i+1 > 0 && i+1 < n) && (j+1 > 0 && j+1 < n))
                            nums[i+1][j+1] = 1;
                        if ((i+1 > 0 && i+1 < n) && (j-1 > 0 && j-1 < n))
                            nums[i+1][j-1] = 1;
                        if ((i-1 > 0 && i-1 < n) && (j+1 > 0 && j+1 < n))
                            nums[i-1][j+1] = 1;

                        if ((i-2 > 0 && i-2 < n) && (j-2 > 0 && j-2 < n))
                            nums[i-2][j-2] = 1;
                        if ((i+2 > 0 && i+2 < n) && (j+2 > 0 && j+2 < n))
                            nums[i+2][j+2] = 1;
                        if ((i+2 > 0 && i+2 < n) && (j-2 > 0 && j-2 < n))
                            nums[i+2][j-2] = 1;
                        if ((i-2 > 0 && i-2 < n) && (j+2 > 0 && j+2 < n))
                            nums[i-2][j+2] = 1;
                    }
                }
            }

            System.out.println(count(nums, x, y, x1, y1));
        }
    }

    private static int count(int[][] nums, int x, int y, int x1, int y1) {
        int[][] dp = new int[nums.length][nums[0].length];
        if (nums[x][y] != 0)
            return -1;
        dp[x][y] = 0;
        for (int i = 1; i < nums[0].length; i++) {
            if (nums[0][i] == 0 && nums[0][i-1] == 0)
                dp[0][i] = 1 + dp[0][i-1];
            else {
                dp[0][i] = Integer.MAX_VALUE;
            }
        }
        for (int i = 1; i < nums.length; i++) {
            if (nums[i][0] == 0 && nums[i-1][0] == 0)
                dp[i][0] = 1 + dp[i-1][0];
            else {
                dp[i][0] = Integer.MAX_VALUE;
            }
        }
        for (int i = 1; i < nums.length; i++) {
            for (int j = 1; j < nums[0].length; j++) {
                if (nums[i][j] == 0) {
                    dp[i][j] = 1 + Math.min(dp[i-1][j], dp[i][j-1]);
                    if (i+1 < nums.length && i+1 >= 0)
                        dp[i][j] = Math.min(dp[i][j], 1 + dp[i+1][j]);
                    if (j+1 < nums.length && j+1 >= 0)
                        dp[i][j] = Math.min(dp[i][j], 1 + dp[i][j+1]);
                }
                else
                    dp[i][j] = Integer.MAX_VALUE;
            }
        }
        return dp[x1][y1] != Integer.MAX_VALUE ? dp[x1][y1] : -1;
    }
}
