package Fenbi;

import java.util.Arrays;

/**
 * Created by pengshuang on 17/9/15.
 */
public class MultipyArray {
    static int[] solove(int[] A) {
        int length = A.length;
        int[] B = new int[length];
        if (length != 0) {
            B[0] = 1;
            for (int i = 1; i < length; i++) {
                B[i] = B[i-1] * A[i-1];
            }
            int temp = 1;
            for (int i = length-2; i >= 0; i--) {
                temp *= A[i+1];
                B[i] *= temp;
            }
        }
        return B;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4};
        System.out.println(Arrays.toString(solove(nums)));
    }
}
