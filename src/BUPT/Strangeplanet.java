package BUPT;

import java.util.*;

public class Strangeplanet {
    public static void main(String [] args){
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            int n = in.nextInt();
            int T = in.nextInt();
            int[] nums = new int[n];
            double tmp = 0;
            for (int i = 0; i < n; i++) {
                tmp += Math.sqrt(2 * in.nextInt());
            }
            double res = Math.pow(tmp / T, 2);
            System.out.println(String.format("%.7f", res));
        }
    }
}
