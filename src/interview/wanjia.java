package interview;

import java.util.*;
/*

最近有人发现怎样在 Y-Crate 游戏设备上运行开源软件。许多设计师做了些有创意的游戏。现在要测试某个游戏项目。每场游戏包含至多100个房间。其中房间 1 是起点，房间 n 是终点。每个房间有-100~100之间的能量值。还有一些单向边连接这些房间。
玩家从起点出发，有100个初始能量。他可以从某个房间出发，进入另一个房间，同时加上该房间的能量。这个过程持续到走到终点，或者耗尽能量而死亡。值得一提的是，他可以经过同个房间任意次，且每次都能接受该房间的能量。

输入
第1行一个整数 n (n<100)。
第2~n+1行，每行第一个整数表示该房间能量值。接下来是从该房间能到达的房间名单，一个整数表示房间数，后面是能到达的房间编号。

输出
若玩家能到达终点，输出 "winnable"，否则输出 "hopeless"。


样例输入
5
0 1 2
-60 1 3
-60 1 4
20 1 5
0 0
 */

public class wanjia {
        public static void main(String[] args){
            Scanner sc = new Scanner(System.in);
            while (sc.hasNext()){
                int n = sc.nextInt();
                int total = 100;
                int[] value = new int[n];
                int[] connect = new int[n];
                boolean[][] isConnect = new boolean[n][n];
                for (int i = 0; i < n; i++) {
                    value[i] = sc.nextInt();
                    connect[i] = sc.nextInt();
                    for (int j = 0; j < connect[i]; j++) {
                        int next = sc.nextInt() - 1;
                        isConnect[i][next] = true;
                    }
                }
                int start = 0;
                boolean flag = dfs(total, isConnect, value, start);
                if (flag){
                    System.out.println("winnable");
                }else {
                    System.out.println("hopeless");
                }
            }
        }

        private static boolean dfs(int total, boolean[][] isConnect, int[] value, int start){
            total += value[start];
            if (total > 0 && isConnect[start][isConnect.length-1]
                    && (total + value[isConnect.length-1] >= 0)){
                return true;
            }
            for (int i = 0; i < isConnect.length && i != start; i++) {
                if (isConnect[start][i] && (total + value[i] > 0)){
                    return dfs(total, isConnect, value, i);
                }
            }
            return false;
        }
}
