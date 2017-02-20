package interview;

import java.util.Arrays;

/**
 * Created by pengshuang on 17/2/20.
 */
public class Clearer {
    public static int[][] clearZero(int[][] mat, int n) {
        boolean[] row = new boolean[n];
        boolean[] col = new boolean[n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0){
                    row[i] = true;
                    col[j] = true;
                }

            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (row[i] || col[j]) {
                    mat[i][j] = 0;
                }
            }
        }
        return mat;
    }

    public static void main(String [] args){
        int[][] mat = new int[3][3];
        mat[0][0] = 1;
        mat[0][1] = 2;
        mat[0][2] = 3;
        mat[1][0] = 0;
        mat[1][1] = 1;
        mat[1][2] = 2;
        mat[2][0] = 0;
        mat[2][1] = 0;
        mat[2][2] = 1;
        int [][] mat2 = clearZero(mat, 3);
        for (int i = 0; i < mat2.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                System.out.println(mat[i][j]);
            }
        }

    }
}
