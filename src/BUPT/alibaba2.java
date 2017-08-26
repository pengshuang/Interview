package BUPT;

import java.util.Scanner;

public class alibaba2 {
    public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            String[] line = sc.nextLine().split(" ");
            int n = sc.nextInt();
            int[] nums = new int[line.length];
            for (int i = 0; i < nums.length; i++) {
                nums[i] = Integer.parseInt(line[i]);
            }
            System.out.println(findKth(nums, n));
        }

    static int findKth(int[] a, int k) {
        int n = a.length;
        int p = quickSelect(a, 0, n - 1, n - k + 1);
        return a[p];
    }

    static int quickSelect(int[] a, int lo, int hi, int k) {
        int i = lo, j = hi, pivot = a[hi];
        while (i < j) {
            if (a[i++] > pivot) swap(a, --i, --j);
        }
        swap(a, i, hi);

        int m = i - lo + 1;

        if (m == k)
            return i;
        else if (m > k)
            return quickSelect(a, lo, i - 1, k);
        else
            return quickSelect(a, i + 1, hi, k - m);
    }

    static void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

}