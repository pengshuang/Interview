package Netease;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class test2 {

    public static void main(String [] args){
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            int n = in.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
            }
            List<List<Integer>> subs = permuteUnique(arr);
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < subs.size(); i++) {
                int temp = cal(subs.get(i));
                if (temp > max)
                    max = temp;
            }
            System.out.println(max);
        }
    }

    private static int cal(List<Integer> nums) {
        int res = 0;
        for (int i = 1; i < nums.size(); i++) {
            res += Math.abs(nums.get(i) - nums.get(i-1));
        }
        return res;
    }

    private static List<List<Integer>> permuteUnique(int[] nums) {
        ArrayList<List<Integer>> res = new ArrayList<>();

        if (nums == null) return res;
        if (nums.length == 0) {
            res.add(new ArrayList<Integer>());
            return res;
        }
        Arrays.sort(nums);
        ArrayList<Integer> list = new ArrayList<>();
        int[] visited = new int[nums.length];
        for(int i=0;i<visited.length;i++) visited[i] = 0;
        helper(res, list, visited, nums);
        return res;
    }

    private static void helper(ArrayList<List<Integer>> result,
                        ArrayList<Integer> list, int[] visited, int[] nums) {
        if (list.size() == nums.length) {
            result.add(new ArrayList<Integer>(list));
            return;
        }
        for (int i=0;i<nums.length;i++) {
            if (visited[i]==1 || (i != 0 && nums[i] == nums[i-1]
                    && visited[i-1] == 0)){
                continue;
            }
            visited[i] = 1;
            list.add(nums[i]);
            helper(result,list,visited,nums);
            list.remove(list.size()-1);
            visited[i] = 0;
        }

    }
}
