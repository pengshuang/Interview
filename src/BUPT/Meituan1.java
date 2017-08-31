package BUPT;

import java.util.Scanner;

public class Meituan1 {

    public static void main(String [] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int flag = -1;
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
        }
        int k = in.nextInt();
        for (int i = nums.length; i >= 1; i--) {
            flag = get(nums, i, k);
            if (flag != -1) {
                System.out.println(flag);
                break;
            }
        }
        if (flag == -1)
            System.out.println(0);

    }

    public static int get(int[] nums, int len, int k) {
        for (int i = 0; i < nums.length - len + 1; i++) {
            int tmp = getSum(nums, i, i + len);
            if (tmp % k == 0)
                return len;
        }
        return -1;

    }

    public static int getSum(int[] nums, int l, int r) {
        int res = 0;
        for (int i = l; i < r; i++) {
            res += nums[i];
        }
        return res;
    }

}
