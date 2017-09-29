package airbnb;


public class Main3 {
    static int minMoves(int[][] maze, int x, int y) {
        int[][] dp = new int[maze.length][maze[0].length];
        return helper(maze, dp, 0, 0);
    }

    static int helper(int[][] maze, int[][] visit, int i, int j) {
        if (i < 0 || i >= maze.length || j < 0 || j >= maze[0].length || maze[i][j] == 1)
            return 0;
        if (visit[i][j] == 1)
            return 0;
        visit[i][j] = 1;
        return  helper(maze, visit,i - 1, j) +
                helper(maze, visit, i + 1, j) +
                helper(maze, visit, i, j - 1) +
                helper(maze, visit, i, j + 1) + maze[i][j];
    }

    public static void main(String[] args) {
        int[][] counts = new int[][]{{0,1,0}, {0,2,2}, {1,0,0}};
        int[][] counts2 = new int[][]{{0,2,0}, {0,0,1}, {1,1,1}};
        System.out.println(minMoves(counts, 0, 2));
    }
}
