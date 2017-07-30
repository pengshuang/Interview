package BUPT;

import java.util.Scanner;

public class Main4 {
    public static void main(String [] args){
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            int n = in.nextInt();
            double res = 0;
            res = Math.pow(n, n - 1) % 1000000007;
            System.out.println((int)res);
        }
    }
}
