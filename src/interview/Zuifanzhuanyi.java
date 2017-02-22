package interview;

import java.util.Scanner;

public class Zuifanzhuanyi {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            int n = in.nextInt();
            int t = in.nextInt();
            int c = in.nextInt();
            int[] nums = new int[n];
            int count = 0;
            int res = 0;
            for (int i = 0; i < n; i++) {
                nums[i] = in.nextInt();
            }
            for (int i = 0; i < c; i++) {
                count += nums[i];
            }
            if (count <= t)
                res++;
            for (int i = c; i < n; i++) {
                count -= nums[i - c];
                count += nums[i];
                if (count <= t){
                    res++;
                }
            }
            System.out.println(res);
        }

    }
}
