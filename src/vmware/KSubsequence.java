package vmware;

import java.util.ArrayList;
import java.util.List;

public class KSubsequence {

    static int count = 0;

    public static void main(String [] args) {
        int[] nums = new int[] {1,2,3};
        int k = 3;
        System.out.println(findAllSubsequences(nums, k));
    }

    static int findAllSubsequences(int[] nums, int k) {
        List<Integer> holder = new ArrayList<>();
        findSequence(holder, 0, nums, k);
        return count;
    }

    static void findSequence(List<Integer> holder, int index, int[] nums, int k) {
        if (getSum(holder)%k == 0 && holder.size() > 0) {
            System.out.println(holder.toString());
           count++;
        }
        for (int i = index; i < nums.length; i++) {
                holder.add(nums[i]);
                findSequence(holder, i + 1, nums, k);
                holder.remove(holder.size() - 1);
        }
    }

    static int getSum(List<Integer> nums) {
        int count = 0;
        for (int i = 0; i < nums.size(); i++) {
            count += nums.get(i);
        }
        return count;
    }

}
