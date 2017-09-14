package Toutiao;

import java.util.Scanner;

public class Main {
    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = sc.nextInt();
            }
            int m = sc.nextInt();
            for (int i = 0; i < m; i++) {
                int l = sc.nextInt();
                int r = sc.nextInt();
                int k = sc.nextInt();
                System.out.println(count(nums,l,r,k));
            }
        }
    }

    static int count(int[] nums, int l, int r, int k) {
        int res = 0;
        for (int i = l-1; i <= r-1; i++) {
            if (nums[i] == k)
                res++;
        }
        return res;
    }
}
