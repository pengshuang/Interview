package interview;

import java.util.Scanner;

public class UpRoad {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            int n = in.nextInt();
            int a = in.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = in.nextInt();
            }
            int res = a;
            for (int i = 0; i < n; i++) {
                if (nums[i] < res){
                    res += nums[i];
                } else {
                    res += gcd(res, nums[i]);
                }
            }
            System.out.println(res);
        }
    }

    private static int gcd(int x, int y){
        return y == 0 ? x : gcd(y, x % y);
    }
}
