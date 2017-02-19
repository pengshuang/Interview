package interview;

import java.util.*;

public class Bonus {
    public static int getMost(int[][] board) {
        int row = board.length;
        int col = board[0].length;
        int[][] maxValue = new int[row][col];
        maxValue[0][0] = board[0][0];
        for (int i = 1; i < row; i++) {
            maxValue[i][0] = board[i][0] + maxValue[i - 1][0];
        }
        for (int j = 1; j < col; j++) {
            maxValue[0][j] = board[0][j] + maxValue[0][j - 1];
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                maxValue[i][j] = Math.max(maxValue[i - 1][j], maxValue[i][j - 1]) + board[i][j];
            }
        }
        return maxValue[row - 1][col - 1];
    }

    public static void main(String [] args){
        int[][] num = new int[3][3];
        for (int i = 0; i < num.length; i++) {
            for (int j = 0; j < num[0].length; j++) {
                num[i][j] = 1;
            }
        }
        System.out.println(getMost(num));
    }
}
