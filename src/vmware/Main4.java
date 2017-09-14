package vmware;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by pengshuang on 17/9/13.
 */
public class Main4 {

    public static void main(String [] args) {
        int[] nums = new int[] {1,2,3};
        System.out.println(findAllSubsequences(nums));
    }

    static List<List<Integer>> findAllSubsequences(int[] nums) {
        Set<List<Integer>> res= new HashSet<List<Integer>>();
        List<Integer> holder = new ArrayList<Integer>();
        findSequence(res, holder, 0, nums);
        List result = new ArrayList(res);
        return result;
    }

    static void findSequence(Set<List<Integer>> res, List<Integer> holder, int index, int[] nums) {
        if (holder.size() >= 1) {
            res.add(new ArrayList(holder));
        }
        for (int i = index; i < nums.length; i++) {
                holder.add(nums[i]);
                findSequence(res, holder, i + 1, nums);
                holder.remove(holder.size() - 1);
        }
    }
}
