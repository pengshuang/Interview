package interview;

/**
 * Created by pengshuang on 17/2/17.
 */
public class LongestDistance {
    public static int getDis(int[] A, int n) {
        // write code here
        int dis = 0;
        for (int i = 0; i < n; i++){
            for (int j = 0; j < i; j++) {
                int temp = A[i] - A[j];
                if (temp > dis && i < n){
                    dis = temp;
                }
            }
        }
        return dis;
    }

    public static void main(String [] args) {
        System.out.println(getDis(new int[]{10, 5}, 2));
    }
}
