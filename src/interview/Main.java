package interview;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/*
输入范例:
2 5 8 7 7 4 5 9 5 2
5 9 5 0 4 2 1 7 2 0
4 4 7 0 0 1 6 1 2 7
4 4 3 4 2 0 8 9 1 5
3 6 4 1 8 1 3 1 0 7
7 5 1 7 7 1 0 5 5 3
3 9 7 8 3 1 0 3 2 1
8 6 9 5 7 9 8 0 0 8
7 9 3 0 6 2 3 7 8 8
0 3 7 9 1 2 3 1 7 5
2 10 10 3 26

输出范例:
175
2,10 3,10 4,10 4,9 4,8 4,7 4,8 4,7 4,8 4,7 4,8 4,7 4,8 4,7 4,8 4,7 5,7 5,6 5,5 6,5 6,4 7,4 7,3 8,3 9,3 10,3
*/

public class Main {

    static boolean insq(int x, int y) {
        if(x >= 0 && x < 10 && y >= 0 && y < 10)
            return true;
        return false;
    }
    static int idx(int x, int y) {
        return x * 10 + y;
    }

    static int FindPath(int num, int i0, int j0, int in, int jn, int step, int[][] data) {
        int[] dx = {-1,0,1,0};
        int[] dy = {0,1,0,-1};
        i0 -= 1;
        j0 -= 1;
        in -= 1;
        jn -= 1;
        int[][] dp = new int[step][100];
        dp[0][idx(i0,j0)] = num;

        for (int i = 0; i < 100; i++){
            if(i != idx(i0,j0))
                dp[0][i] = -1;
        }
        for(int i = 0; i < step; ++i) {
            for(int j = 0; j < 100; ++j) if(dp[i][j] != -1) {
                int x = j / 10;
                int y = j % 10;
                int index;
                for(int d = 0; d < 4; ++ d) {
                    if(insq(x + dx[d], y + dy[d])) {
                        index = idx(x + dx[d], y + dy[d]);
                        dp[i+1][index] = Math.max(dp[i+1][index], dp[i][j] + data[x + dx[d]][y + dy[d]]);
                    }
                }
            }
        }
        return dp[step][in * 10 + jn];
    }

        public static void main(String[] args){
            Scanner in = new Scanner(System.in);
            int res;

            int _num;
            _num = Integer.parseInt(in.nextLine().trim());

            int _i0;
            _i0 = Integer.parseInt(in.nextLine().trim());

            int _j0;
            _j0 = Integer.parseInt(in.nextLine().trim());

            int _in;
            _in = Integer.parseInt(in.nextLine().trim());

            int _jn;
            _jn = Integer.parseInt(in.nextLine().trim());

            int _step;
            _step = Integer.parseInt(in.nextLine().trim());

            int _data_rows = 0;
            int _data_cols = 0;
            _data_rows = Integer.parseInt(in.nextLine().trim());
            _data_cols = Integer.parseInt(in.nextLine().trim());

            int[][] _data = new int[_data_rows][_data_cols];
            for(int _data_i=0; _data_i<_data_rows; _data_i++) {
                for(int _data_j=0; _data_j<_data_cols; _data_j++) {
                    _data[_data_i][_data_j] = in.nextInt();

                }
            }

            if(in.hasNextLine()) {
                in.nextLine();
            }

            res = FindPath(_num, _i0, _j0, _in, _jn, _step, _data);
            System.out.println(String.valueOf(res));

        }
}
