package vmware;

import java.util.*;

/**
 * Created by pengshuang on 17/9/13.
 */
public class Main3 {

    public static void main(String [] args) {
        int[] nums = new int[] {1,2,3};
        System.out.println(findSubsequences(nums));
    }

    static List<List<Integer>> findSubsequences(int[] nums) {
        Set<List<Integer>> res= new HashSet<List<Integer>>();
        List<Integer> holder = new ArrayList<Integer>();
        findSequence(res, holder, 0, nums);
        List result = new ArrayList(res);
        return result;
    }

    static void findSequence(Set<List<Integer>> res, List<Integer> holder, int index, int[] nums) {
        if (holder.size() >= 2) {
            res.add(new ArrayList(holder));
        }
        for (int i = index; i < nums.length; i++) {
            if(holder.size() == 0 || holder.get(holder.size() - 1) <= nums[i]) {
                holder.add(nums[i]);
                findSequence(res, holder, i + 1, nums);
                holder.remove(holder.size() - 1);
            }
        }
    }
}
