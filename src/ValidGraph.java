import java.util.*;

/**
 * Created by pengshuang on 17/9/14.
 */
public class ValidGraph {
    static boolean validTree(int n, int[][] edges) {
        if (n == 0) {
            return false;
        }
        if (edges.length != n - 1) {
            return false;
        }
        Map<Integer, Set<Integer>> graph = initializeGraph(n, edges);
        // bfs
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> hash = new HashSet<>();
        queue.offer(0);
        hash.add(0);
        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (Integer neighbor : graph.get(node)) {
                if (hash.contains(neighbor)) {
                    continue;
                }
                hash.add(neighbor);
                queue.offer(neighbor);
            }
        }
        return (hash.size() == n);
    }

    static Map<Integer, Set<Integer>> initializeGraph(int n, int[][] edges) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.put(i, new HashSet<Integer>());
        }

        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        return graph;
    }

    public static void main(String [] args) {
        int[][] g = new int[][]{{0, 1}, {1, 2}, {2, 3}, {1, 3},{1, 4}};
        boolean flag = validTree(5, g);
        System.out.println(flag);
    }
}
