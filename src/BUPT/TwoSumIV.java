package BUPT;

import java.util.ArrayList;

/**
 * Created by pengshuang on 17/8/6.
 */
public class TwoSumIV {
     class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public boolean findTarget(TreeNode root, int k) {
        if (root == null || (root.left == null && root.right == null))
            return false;

        ArrayList<Integer> nums = inOrder(root);

        int start = 0, end = nums.size() - 1;
        while (start < end){
            if (nums.get(start) + nums.get(end) < k)
                start ++;
            else if (nums.get(start) + nums.get(end) > k)
                end --;
            else
                return true;
        }
        return false;
    }

    private ArrayList<Integer> inOrder(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        traverse(root, res);
        return res;
    }

    private void traverse(TreeNode root, ArrayList<Integer> res) {
        if (root == null)
            return;

        traverse(root.left, res);
        res.add(root.val);
        traverse(root.right, res);
    }

}
