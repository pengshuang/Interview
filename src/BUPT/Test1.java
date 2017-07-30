package BUPT;

import java.util.Scanner;

public class Test1 {

    public static void main(String [] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            int n = in.nextInt();
            int count = 0;
            if (n == 0){
                break;
            }

            boolean[] notPrime = countPrimes(n);
            for (int i = 2; i <= n / 2; i++) {
                if (!notPrime[i] && !notPrime[n - i]){
                    count += 1;
                }
            }
            System.out.println(count);
        }
    }

    private static boolean[] countPrimes(int n) {
        if(n <= 1) return null;

        boolean[] notPrime = new boolean[n];
        notPrime[0] = true;
        notPrime[1] = true;

        for(int i = 2; i < Math.sqrt(n); i++){
            if(!notPrime[i]){
                for(int j = 2; j*i < n; j++){
                    notPrime[i*j] = true;
                }
            }
        }
        return notPrime;
    }
}
