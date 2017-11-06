package YiDong;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] nums = new int[100000 + 10][13];
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int maxt = 0;
            for (int i = 0; i < n; i++) {
                int pos = sc.nextInt();
                int t = sc.nextInt();
                nums[t][pos]++;
                maxt = Math.max(t, maxt);
            }
            for (int i = maxt - 1; i >= 0; i--) {
                nums[i][0] += Math.max(nums[i + 1][0], nums[i + 1][1]);
                for (int j = 1; j <= 10; j++)
                    nums[i][j] += Math.max(Math.max(nums[i + 1][j - 1], nums[i + 1][j]), nums[i + 1][j + 1]);
            }
            System.out.println(nums[0][5]);
        }
    }
}
