package interview;

import java.util.Scanner;

public class Wanggezhi {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            int maxX = Integer.MIN_VALUE;
            int maxY = Integer.MIN_VALUE;
            int minX = Integer.MAX_VALUE;
            int minY = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                int x = in.nextInt();
                int y = in.nextInt();
                maxX = (int) Math.max(maxX, x);
                maxY = (int) Math.max(maxY, y);
                minX = (int) Math.min(minX, x);
                minY = (int) Math.min(minY, y);
            }
            int res = Math.max((maxX - minX), (maxY - minY));
            System.out.println(res*res);
        }
    }
}
