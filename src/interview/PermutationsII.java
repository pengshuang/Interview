package interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by pengshuang on 17/2/13.
 * 全排序
 */
public class PermutationsII {
    public List<List<Integer>> permute(int[] nums) {
        ArrayList<List<Integer>> res = new ArrayList<>();

        if (nums == null) return res;
        if (nums.length == 0) {
            res.add(new ArrayList<Integer>());
            return res;
        }
        Arrays.sort(nums);
        ArrayList<Integer> list = new ArrayList<>();
        int[] visited = new int[nums.length];
        for (int i = 0; i < visited.length; i++) {
            visited[i] = 0;
        }
        helper(res, list, visited, nums);
        return res;
    }

    private void helper(List<List<Integer>> rst, List<Integer> list, int[] visited, int[] nums) {
        if(list.size() == nums.length) {
            rst.add(new ArrayList<Integer>(list));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (visited[i] == 1 || (i != 0 && nums[i] == nums[i-1] && visited[i-1] == 0)) {
                continue;
            }
            visited[i] = 1;
            list.add(nums[i]);
            helper(rst, list, visited, nums);
            list.remove(list.size() - 1);
            visited[i] = 0;
        }
    }
}
