package interview;

import java.util.Map;

/**
 * Created by pengshuang on 17/2/7.
 */
public class ArraySummary {
    int[] buffer = new int[100];

    public static void main(String[] args){
        int[] arr = new int[]{0};
        int[] arr2 = new int[]{4,5};
        char[] arr3 = new char[]{'a', 'b', 'c'};
        int res = maxSubProduct(arr);
        System.out.println(res);

        StrReverse(arr3);
        System.out.println(arr3);

    }

    private static int sum(int[] arr, int size){
        return size == 0 ? 0 : sum(arr, size - 1) + arr[size - 1];
    }

    private static int[] SecondMax(int[] arr){
        int m1 = arr[0];
        int m2 = arr[0];

        for (int i = 1; i < arr.length; i++){
            if (m1 < arr[i]){
                m2 = m1;
                m1 = arr[i];
            }
            else {
                if (m2 < arr[i]){
                    m2 = arr[i];
                }
            }
        }

        return new int[]{m2, m1};
    }
    // 选择排序
    private static int[] SecondMax2(int[] arr){
        int k , tmp;
        for (int i = 0; i < 2; i++){
            k = i;
            for (int j = i; j < arr.length; j++){
                if (arr[j] > arr[k])
                    k = j;
            }
            tmp = arr[k];
            arr[k] = arr[i];
            arr[i] = tmp;
        }

        return new int[]{arr[0], arr[1]};
    }

    private static int majorityElement(int[] arr){
        int curV = arr[0];
        int count = 1;
        for(int i = 1; i < arr.length; i++){
            if (arr[i] == curV)
                count++;
            else{
                count--;
                if (count < 0){
                    curV = arr[i];
                    count = 1;
                }
            }
        }
        return curV;
    }

    private static int findCommon(int[] arr1, int[] arr2){
        int i = 0;
        int j = 0;
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] < arr2[j])
                ++i;
            else if (arr1[i] == arr2[j]) {
                return arr1[i];
            }
            else {
                ++j;
            }
        }
        return 0;
    }

    private static int maxSubSum(int[] arr){
        int curSum = 0;
        int maxSum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (curSum + arr[i] < 0)
                curSum = 0;
            else {
                curSum += arr[i];
                maxSum = Math.max(maxSum, curSum);
            }
        }
        return maxSum;
    }

    private static int maxSubProduct(int[] arr){
        int maxProduct = 1; // max positive product at current position
        int minProduct = 1; // min negative product at current position
        int r = 1; // result, max multiplication totally
        for (int i = 0; i < arr.length; i++){
            if (arr[i] > 0){
                maxProduct *= arr[i];
                minProduct = Math.min(minProduct * arr[i], 1);
            }
            else if (arr[i] == 0){
                maxProduct = 1;
                minProduct = 1;
            }
            else {
                int temp = maxProduct;
                maxProduct = Math.max(minProduct * arr[i], 1);
                minProduct = temp * arr[i];
            }
            r = Math.max(r, maxProduct);
        }
        return r;
    }

    private static void Reverse(int[] arr, int start, int end){
        while (start < end){
            int temp = arr[start];
            arr[start++] = arr[end];
            arr[end--] = temp;
        }
    }

    private static void Shift(int[] arr, int k){
        k %= arr.length;
        Reverse(arr, 0, arr.length - k - 1);
        Reverse(arr, arr.length - k, arr.length - 1);
        Reverse(arr, 0, arr.length - 1);
    }

    private static void StrReverse(char[] arr){
        int left = 0;
        int right = arr.length - 1;
        while (left < right){
            char temp = arr[left];
            arr[left++] = arr[right];
            arr[right--] = temp;
        }
    }
}
