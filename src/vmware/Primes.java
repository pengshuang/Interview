package vmware;

import java.util.ArrayList;
import java.util.List;

public class Primes {
    public static List<Integer> getPrimes(int n) {
        List<Integer> ret = new ArrayList<>();
        int number = Integer.MAX_VALUE;
        int counter;
        for (int i = 2; i < number; i++) {
            if (n <= 0) {
                break;
            }
            counter = 0;
            for (int j = 2; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    counter++;
                    break;
                }
            }
            if (counter == 0) {
                ret.add(i);
                n--;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(getPrimes(10));
    }
}
