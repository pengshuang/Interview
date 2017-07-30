package BUPT;

import java.util.*;

public class Sumofprime {
    static int MaxSize = 30;
    static boolean[] Primes = new boolean[MaxSize];
    static int[] Mark = new int[MaxSize];

    public static void main(String [] args) {
        Scanner in = new Scanner(System.in);
        int index = countPrimes();
        int[] sum = new int[MaxSize];
        Set<Integer> mark = new TreeSet<>();
        sum[0] = Mark[0];
        mark.add(sum[0]);
        for (int i = 1; i < index; i++) {
            sum[i] = sum[i - 1] + Mark[i];
            mark.add(sum[i]);
        }
        System.out.println(Arrays.toString(sum));
        System.out.println(Arrays.toString(Mark));
        while (in.hasNext()){
            int count = 0;
            int n = in.nextInt();
            for (int i = 0; i < n; i++) {
                if (Mark[i] > n){
                    break;
                }
                int tmp = 0;
                if (i != 0){
                    tmp = sum[i-1];
                }
                if (mark.contains(tmp + n)){
                    count += 1;
                }
            }
            System.out.println(count);
        }
    }

    private static int countPrimes() {
        int index = 0;
        for(int i = 2; i < MaxSize; i++){
            if(!Primes[i]){
                Mark[index++] = i;
            }
            for(int j = 0; Mark[j] * i < MaxSize && j < index; j++){
                Primes[i * Mark[j]] = true;
                if (i % Mark[j] == 0){
                    break;
                }
            }
        }
        return index;
    }
}
