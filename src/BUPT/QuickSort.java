package BUPT;

import java.util.Arrays;

/**
 * Created by pengshuang on 17/8/23.
 */
public class QuickSort {
    static void quickSort(int[] n) {
        quickSort(n, 0, n.length - 1);
    }
    static void quickSort(int[] n, int left, int right) {
        if (n == null || left >= right) {
            return;
        }
        int pivot;
        if (left < right) {
            pivot = partition(n, left, right);
            quickSort(n, left, pivot - 1);
            quickSort(n, pivot + 1, right);
        }
    }

    static int partition(int[] n, int left, int right) {
        int pivot = n[left];
        while (left < right) {
            while (left < right && n[right] >= pivot) {
                right--;
            }
            n[left] = n[right];
            while (left < right && n[left] <= pivot) {
                left++;
            }
            n[right] = n[left];
        }
        n[left] = pivot;
        return left;
    }

    public static void main(String[] args) {
        int[] n = new int[] {2, 3, 1, 5, 6, 5, 5, 1};
        quickSort(n);
        System.out.println(Arrays.toString(n));
    }
}
