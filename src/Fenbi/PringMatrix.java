package Fenbi;

import java.util.ArrayList;

/**
 * Created by pengshuang on 17/9/15.
 */
public class PringMatrix {
    static ArrayList<Integer> solve(int[][] matrix) {
        ArrayList<Integer> res = new ArrayList<>();
        int row = matrix.length;
        int col = matrix[0].length;
        if (row == 0 || col == 0)
            return res;
        int left = 0, top = 0, right = col - 1, bottom = row - 1;
        while (left <= right && top <= bottom) {
            for (int i = left; i <= right; i++) {
                res.add(matrix[top][i]);
            }
            for (int i = top+1; i <= bottom; i++) {
                res.add(matrix[i][right]);
            }
            if (top != bottom)
                for (int i = right-1; i >= left; i--) {
                    res.add(matrix[bottom][i]);
                }
            if (left != right)
                for (int i = bottom-1; i >= top+1; i--) {
                    res.add(matrix[i][left]);
                }
            left++;
            right--;
            top++;
            bottom--;
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                                     {1,2,3,4},
                                     {5,6,7,8},
                                     {9,10,11,12},
                                     {13,14,15,16}
                                    };
        System.out.println(solve(matrix));
    }
}
