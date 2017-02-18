package interview;

import java.util.*;

public class AverageAge {
    public static void main(String [] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            double w = in.nextDouble();
            double y = in.nextDouble();
            double x = in.nextDouble();
            int n = in.nextInt();

            while (n > 0) {
                y = (y + 1 + (20 - y)*x);
                n--;
            }
            System.out.println((int)Math.ceil(y));
        }
    }
}
