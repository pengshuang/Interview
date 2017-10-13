package xiaohong;

import java.util.Scanner;

public class Main5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = sc.nextInt();

            }
            int wid = sc.nextInt();
            System.out.println(calculate(nums, wid));
        }
    }

    static double calculate(int[] nums, int k) {
        int res = Integer.MIN_VALUE;
        int tmp = getSum(nums, 0, k - 1);
        for (int i = k-1; i < nums.length; i++) {
            tmp += nums[i];
            res = Math.max(res, tmp);
            tmp -= nums[i - k + 1];
        }
        return (double)res / k;
    }

    static int getSum(int[] nums, int l, int r) {
        int res = 0;
        for (int i = l; i < r; i++) {
            res += nums[i];
        }
        return res;
    }
}
