package interview;

import java.util.Scanner;

public class Paotaigongji {
    public static void main(String [] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            int r = in.nextInt();
            int x1 = in.nextInt();
            int y1 = in.nextInt();
            int x2 = in.nextInt();
            int y2 = in.nextInt();
            int x3 = in.nextInt();
            int y3 = in.nextInt();
            int x0 = in.nextInt();
            int y0 = in.nextInt();
            int res = 0;
            if (calDistance(x1, y1, x0, y0) <= r){
                res += 1;
            }
            if (calDistance(x2, y2, x0, y0) <= r){
                res += 1;
            }
            if (calDistance(x3, y3, x0, y0) <= r){
                res += 1;
            }
            System.out.println(res + "x");
        }
    }

    public static double calDistance(int x1, int y1, int x2, int y2) {
        double distance = Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
        return distance;
    }
}
