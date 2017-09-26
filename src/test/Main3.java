package test;

import java.util.Scanner;

public class Main3 {

    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int size = count(n);
            int count = size - (n - 1);
            String result = String.format("%.4f", count/(float)size);
            System.out.println(result);
        }
    }

    static int count(int n) {
        if (n == 1)
            return 1;
        return n * count(n-1);
    }
}
