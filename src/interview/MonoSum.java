package interview;

/**
 * Created by pengshuang on 17/2/19.
 */

public class MonoSum {
    public static int calcMonoSum(int[] A, int n) {
        int count = 0;
        for (int i = 1; i < A.length; i++) {
            int temp = 0;
            for (int j = 0; j < i; j++) {
                if (A[j] <= A[i]){
                    temp += A[j];
                }
            }
            count += temp;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(calcMonoSum(new int[]{1,3,5,2,4,6}, 6));
    }
}
