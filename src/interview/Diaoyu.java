package interview;

import java.util.*;

public class Diaoyu {
    public static void main(String [] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            int n = in.nextInt();
            int m = in.nextInt();
            int x = in.nextInt() - 1;
            int y = in.nextInt() - 1;
            int t = in.nextInt();
            in.nextLine();
            double [][] p = new double[n][m];
            for (int i = 0; i < n; i++) {
                String[] content = in.nextLine().split(" ");
                for (int j = 0; j < m; j++) {
                    p[i][j] = Double.parseDouble(content[j]);
                }
            }
            double count = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    count += p[i][j];
                }
            }
            double avg = count / (n * m);
            if (p[x][y] > avg){
                System.out.println("cc");
                System.out.println(String.format("%.2f", 1 - Math.pow(1 - p[x][y], t)));
            } else if (p[x][y] < avg){
                System.out.println("ss");
                System.out.println(String.format("%.2f", 1 - Math.pow(1 - avg, t)));
            } else {
                System.out.println("equal");
                System.out.println(String.format("%.2f", 1 - Math.pow(1 - avg, t)));
            }
        }
    }
}
