package interview;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by pengshuang on 17/3/30.
 */


public class ValidCompleteTree {

    private class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            val = x;
        }
    }
    public static boolean isCompleteBinaryTree(TreeNode root){
        if (root == null){
            return false;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean mustHaveNoChild = false;
        boolean result = true;

        while (!queue.isEmpty()) {
            TreeNode cur = queue.remove();
            if (mustHaveNoChild){
                if (cur.left != null || cur.right != null){
                    result = false;
                    break;
                }
            } else {
                if (cur.left != null && cur.right != null){
                    queue.add(cur.left);
                    queue.add(cur.right);
                } else if (cur.left != null && cur.right == null){
                    mustHaveNoChild = true;
                    queue.add(cur.left);
                } else if(cur.left == null && cur.right != null) {
                    result = false;
                    break;
                } else {
                    mustHaveNoChild = true;
                }
            }
        }
        return result;
    }


}
