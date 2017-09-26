package test;

import java.util.Scanner;

public class Main {

    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int[][] person = new int[n][2];
            int[][] safe = new int[n][2];

            for (int i = 0; i < n; i++) {
                person[i][0] = sc.nextInt();
                person[i][1] = sc.nextInt();
            }

            for (int i = 0; i < n; i++) {
                safe[i][0] = sc.nextInt();
                safe[i][1] = sc.nextInt();
            }

            int[][] distant1 = new int[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    distant1[i][j] = Math.abs(person[i][0] - safe[j][0])
                            + Math.abs(person[i][1] - safe[j][1]);
                }
            }
            int flag = Integer.MIN_VALUE;
            int index = 0;
            for (int i = 0; i < n; i++) {
                int dis = 0;
                for (int j = 0; j < n; j++) {
                    dis += distant1[i][j];
                }
                if (dis > flag){
                    index = i;
                    flag = Math.max(flag, dis);
                }
            }

            int res = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                    res = Math.min(res, distant1[index][i]);
                }
            System.out.println(res);
        }
    }
}
