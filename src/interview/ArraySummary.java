package interview;

/**
 * Created by pengshuang on 17/2/7.
 */
public class ArraySummary {
    public static void main(String[] args){
        int[] arr = new int[]{1,2,3,4,5};
        int count = sum(arr, arr.length);
        System.out.println(count);



    }

    private static int sum(int[] arr, int size){
        return size == 0 ? 0 : sum(arr, size - 1) + arr[size - 1];
    }

    private static int[] MaxandMin(int[] arr, int l, int r){
        int maxValue, minValue;
        if (l == r){
            maxValue = arr[l];
            minValue = arr[l];
            return new int[]{minValue, maxValue};
        }


    }
}
