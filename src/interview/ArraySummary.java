package interview;

import java.util.Map;

/**
 * Created by pengshuang on 17/2/7.
 */
public class ArraySummary {
    public static void main(String[] args){
        int[] arr = new int[]{1,2,3,4,5};
        int count = sum(arr, arr.length);
        System.out.println(count);

        int [] res = SecondMax2(arr);
        System.out.println(res[1] + " " + res[0]);
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
}
