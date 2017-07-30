package test;

import java.util.*;

public class test {

    public static void main(String [] args){
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            int x = in.nextInt();
            if (x >= 5){
                System.out.println("-1");
                break;
            }
            int i = 0;
            while (i < Integer.MAX_VALUE){
                if (numOfzero(fac(i)) == x) {
                    System.out.println(i);
                    break;
                }
                i += 1;
            }
        }
    }

    private static long fac(int nums){
        if (nums == 0){
            return 1;
        }
        if (nums == 1){
            return 1;
        }
        return fac(nums-1) * nums;
    }

    private static int numOfzero(long nums){
        int count = 0;
        while (nums%10==0) {
            nums /= 10;
            count += 1;
        }
        return count;
    }
}
