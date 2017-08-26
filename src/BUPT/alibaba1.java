package BUPT;

import java.util.*;

public class alibaba1 {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            String[] line = sc.nextLine().split(" ");
            int[] nums = new int[line.length];
            for (int i = 0; i < line.length; i++) {
                nums[i] = Integer.parseInt(line[i]);
            }
            System.out.println(count(nums));
        }

        static int count(int[] nums) {
            int local = nums[0];
            int maxV = nums[0];
            for (int i = 1; i < nums.length; i++) {
                local = Math.max(local + nums[i], nums[i]);
                maxV = Math.max(local, maxV);
            }
            return maxV;
        }
}