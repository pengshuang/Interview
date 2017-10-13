package xiaohong;

import java.util.Scanner;

public class Main4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = sc.nextInt();
            }
            System.out.println(solve(nums));
        }
    }

    static int solve(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (getSum(nums, i, j) * 2 == j - i + 1)
                    res = Math.max(res, j - i + 1);
            }
        }
        return res;
    }

    static int getSum(int[] nums, int l, int r) {
        int res = 0;
        for (int i = l; i <= r; i++) {
            res += nums[i];
        }
        return res;
    }
}
