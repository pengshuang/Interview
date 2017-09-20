import java.util.LinkedList;
import java.util.Queue;

class Coordinate {
    int x, y;
    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class MaxOfSurrounding {
    /**
     * @param grid a boolean 2D matrix
     * @return an integer
     */

    static int numIslands(int[][] grid, int k) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int n = grid.length;
        int m = grid[0].length;
        int islands = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j]>0) {
                    boolean flag = markByBFS(grid, i, j, k);
                    if (flag)
                        islands++;
                }
            }
        }

        return islands;
    }

    static boolean markByBFS(int[][] grid, int x, int y, int k) {
        int[] directionX = {0, 1, -1, 0};
        int[] directionY = {1, 0, 0, -1};

        Queue<Coordinate> queue = new LinkedList<>();
        int tmp = 1;

        queue.offer(new Coordinate(x, y));
        grid[x][y] = 0;

        while (!queue.isEmpty()) {
            Coordinate coor = queue.poll();
            for (int i = 0; i < 4; i++) {
                Coordinate adj = new Coordinate(
                        coor.x + directionX[i],
                        coor.y + directionY[i]
                );
                if (!inBound(adj, grid)) {
                    continue;
                }
                if (grid[adj.x][adj.y] > 0) {
                    tmp++;
                    grid[adj.x][adj.y] = 0;
                    queue.offer(adj);
                }
            }
        }
        return tmp > k;
    }

    static boolean inBound(Coordinate coor, int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        return coor.x >= 0 && coor.x < n && coor.y >= 0 && coor.y < m;
    }

    public static void main(String [] args) {
        int[][] g = new int[][]{{1, 1, 0, 0, 0},
                                {0, 1, 0, 0, 1},
                                {0, 0, 0, 1, 1},
                                {0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 1}};
        int count = numIslands(g, 4);
        System.out.println(count);
    }
}

