package BUPT;

import java.util.*;

public class Triplet {
    public static void main(String [] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        while (T > 0){
            int n = in.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = in.nextInt();
            }
            long res = threeSum(nums);
            res %= 1000000007;
            System.out.println(res);
            T -= 1;
        }
    }

    private static long calculate(List<Integer> nums){
        long count = 0;
        for (int i = 0; i < nums.size(); i++) {
            count += Math.pow(nums.get(i),2);
        }
        return count % 1000000007;
    }

    private static long threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        long count = 0;
        if(nums.length < 3)
            return 0;
        Arrays.sort(nums);
        int i = 0;
        while(i < nums.length - 2) {
            if(nums[i] > 0) break;
            int j = i + 1;
            int k = nums.length - 1;
            while(j < k) {
                long sum = nums[i] + nums[j] + nums[k];
                if(sum == 0)
                    count += calculate(Arrays.asList(nums[i], nums[j], nums[k]));
                if(sum <= 0)
                    while(nums[j] == nums[++j] && j < k);
                if(sum >= 0)
                    while(nums[k--] == nums[k] && j < k);
            }
            while(nums[i] == nums[++i] && i < nums.length - 2);
        }
        return count;
    }
}
