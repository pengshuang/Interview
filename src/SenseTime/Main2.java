package SenseTime;

import java.util.Scanner;

public class Main2 {
    static int count;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            count = 0;
            int m = sc.nextInt();
            int n = sc.nextInt();
            char[][] nums = new char[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    nums[i][j] = sc.nextInt() == 0 ? 'O' : 'X';
                }
            }
            nums = change(nums);
            System.out.println(numIslands(nums));
        }
    }

    static char[][] change(char[][] board) {
        char[][] newboard = new char[board.length][board[0].length];
        if(board == null || board.length == 0)
            return newboard;
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(i == 0 || i == board.length-1 || j == 0 || j == board[0].length-1){
                    if(board[i][j] == 'O')
                        helper(i,j,board);
                }
            }
        }
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == '*')
                    newboard[i][j] = 'O';
                else {
                    newboard[i][j] = 'X';
                }
            }
        }
        return newboard;
    }
    static void helper(int i,int j,char[][] board){
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length)
            return;
        if(board[i][j] == 'X' || board[i][j] == '*')
            return;
        board[i][j] = '*';
        if(i+1 < board.length)
            helper(i+1,j,board);
        if(i-1 > 0)
            helper(i-1,j,board);
        if(j+1 < board[0].length)
            helper(i,j+1,board);
        if(j-1 > 0)
            helper(i,j-1,board);
    }

    static int numIslands(char[][] grid) {
        int n = grid.length;
        if (n == 0)
            return 0;
        dfs(grid, n-1, 0);
        return count;
    }

    static void dfs(char[][] grid, int i, int j){
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] != 'X'){
            return;
        }
        count++;
        grid[i][j] = 'O';
        dfs(grid,i+1,j);
        dfs(grid,i,j+1);
        dfs(grid,i-1,j);
        dfs(grid,i,j-1);
    }
}
