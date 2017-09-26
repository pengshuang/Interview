package test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main2 {

    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = i + 1;
            }
            ArrayList<ArrayList<Integer>> arr = permute(nums);
            int size = arr.size();
            int count = 0;
            for (int i = 0; i < arr.size(); i++) {
                ArrayList<Integer> list = arr.get(i);
                for (int j = 0; j < list.size(); j++) {
                    if (list.get(j) == nums[j]) {
                        count++;
                        break;
                    }
                }
            }
            System.out.println(size);
            System.out.println(count);
            String result = String.format("%.4f", count/(float)size);
            System.out.println(result);
        }
    }

    static ArrayList<ArrayList<Integer>> permute(int[] nums) {
        ArrayList<ArrayList<Integer>> rst = new ArrayList<>();
        if (nums == null) {
            return rst;
        }
        if (nums.length == 0) {
            rst.add(new ArrayList<Integer>());
            return rst;
        }

        ArrayList<Integer> list = new ArrayList<>();
        helper(rst, list, nums);
        return rst;
    }

    static void helper(ArrayList<ArrayList<Integer>> rst , List<Integer> list, int[] nums) {
        if (list.size() == nums.length) {
            rst.add(new ArrayList<Integer>(list));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (list.contains(nums[i])) {
                continue;
            }
            list.add(nums[i]);
            helper(rst, list, nums);
            list.remove(list.size() - 1);
        }
    }
}
