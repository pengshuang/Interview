package DiDi;

import java.util.HashSet;
import java.util.Scanner;


public class Main2 {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int n=sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        System.out.println(count(nums));
    }

    static int count(int[] nums) {
        int res = 0;
        int count = 0;
        HashSet<Integer> set = new HashSet<>();
        set.add(0);
        for (int i = 0; i < nums.length; i++) {
            res ^= nums[i];
            if (set.contains(res)) {
                count++;
                set.clear();
            }
            set.add(res);
        }
        return count;
    }
}
