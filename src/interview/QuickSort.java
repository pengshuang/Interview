package interview;

import java.util.Arrays;

/**
 * Created by pengshuang on 17/3/13.
 */
public class QuickSort {
    private static void quickSort(int[] a, int left, int right) {
        if (right <= left)
            return;

    /*
     * 工作指针
     * p指向序列左边等于pivot元素的位置
     * q指向序列右边等于Pivot元素的位置
     * i指向从左向右扫面时的元素
     * j指向从右向左扫描时的元素
     */
        int p, q, i, j;
        int pivot;// 锚点
        i = p = left;
        j = q = right - 1;
    /*
     * 每次总是取序列最右边的元素为锚点
     */
        pivot = a[right];
        while (true) {
        /*
         * 工作指针i从右向左不断扫描，找小于或者等于锚点元素的元素
         */
            while (i < right && a[i] <= pivot) {
            /*
             * 找到与锚点元素相等的元素将其交换到p所指示的位置
             */
                if (a[i] == pivot) {
                    swap(a, i, p);
                    p++;
                }
                i++;
            }
        /*
         * 工作指针j从左向右不断扫描，找大于或者等于锚点元素的元素
         */
            while (left <= j && a[j] >= pivot) {
            /*
             * 找到与锚点元素相等的元素将其交换到q所指示的位置
             */
                if (a[j] == pivot) {
                    swap(a, j, q);
                    q--;
                }
                j--;
            }
        /*
         * 如果两个工作指针i j相遇则一趟遍历结束
         */
            if (i >= j)
                break;

        /*
         * 将左边大于pivot的元素与右边小于pivot元素进行交换
         */
            swap(a, i, j);
            i++;
            j--;
        }
    /*
     * 因为工作指针i指向的是当前需要处理元素的下一个元素
     * 故而需要退回到当前元素的实际位置，然后将等于pivot元素交换到序列中间
     */
        i--;
        p--;
        while (p >= left) {
            swap(a, i, p);
            i--;
            p--;
        }
    /*
     * 因为工作指针j指向的是当前需要处理元素的上一个元素
     * 故而需要退回到当前元素的实际位置，然后将等于pivot元素交换到序列中间
     */
        j++;
        q++;
        while (q <= right) {
            swap(a, j, q);
            j++;
            q++;
        }

    /*
     * 递归遍历左右子序列
     */
        quickSort(a, left, i);
        quickSort(a, j, right);
    }

    private static void quick(int[] a) {
        if (a.length > 0) {
            quickSort(a, 0, a.length - 1);
        }
    }

    private static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void main(String[] args){
        int a[] = {1,1,1,1,5,3,4,6,7,8,9,2,11};
        quick(a);
        System.out.println(Arrays.toString(a));
    }
}
