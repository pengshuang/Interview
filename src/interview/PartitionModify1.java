package interview;

import java.util.Arrays;

/**
 * Created by pengshuang on 17/2/17.
 */

/*
    arr[0...u] 上都是无重复元素且升序的。 u 是这个区域最后的位置, A区域
    arr[u+1...i] 上是不保证没有重复元素且升序的区域,i 是这个区域最后的位置, B区域
    i 向右移动 i++,如果 arr[i] != arr[u], 说明当前数 arr[i] 应该加入到 A 区域
 */
public class PartitionModify1 {
    public static void leftUnique(int[] arr) {
        if (arr == null || arr.length < 2){
            return;
        }
        int u = 0;
        int i = 1;
        while (i != arr.length) {
            if (arr[i++] != arr[u]) {
                swap(arr, ++u, i - 1);
            }
        }
    }
    /*
        arr[0..left]
        arr[left+1..index]
        arr[right..N-1]
     */

    public static void sort(int[] arr) {
        if (arr == null || arr.length < 2){
            return;
        }
        int left = -1;
        int index = 0;
        int right = arr.length;
        while (index < right){
            if (arr[index] == 0){
                swap(arr, ++left, index++);
            } else if (arr[index] == 2) {
                swap(arr, index, --right);
            } else {
                index++;
            }
        }
    }

    private static void swap(int[] arr, int start, int end) {
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
    }

    public static void main(String [] args) {
        int[] a = new int[]{1,2,2,0,1};
        leftUnique(a);
        System.out.println(Arrays.toString(a));
    }


}
