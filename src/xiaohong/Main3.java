package xiaohong;

import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = sc.nextInt();
            }
            int total = sc.nextInt();
            System.out.println(count(nums, total));
        }
    }

    static int count(int[] nums, int amount) {
        if (nums == null || nums.length == 0 || amount <= 0)
            return 0;
        int[] minNumber = new int[amount + 1];
        for (int i = 1; i <= amount; i++) {
            minNumber[i] = Integer.MAX_VALUE;
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] <= i && minNumber[i - nums[j]] != Integer.MAX_VALUE)
                    minNumber[i] = Math.min(minNumber[i], 1 + minNumber[i - nums[j]]);
            }
        }
        if (minNumber[amount] == Integer.MAX_VALUE)
            return -1;
        else
            return minNumber[amount];
    }


}
