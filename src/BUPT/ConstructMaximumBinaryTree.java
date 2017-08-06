package BUPT;

public class ConstructMaximumBinaryTree {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }


    public TreeNode constructMaximumBinaryTree(int[] nums) {

        return buildTree(nums, 0, nums.length-1);
    }

    private TreeNode buildTree(int[] nums, int start, int end){
        if (start > end)
            return null;

        int maxV = getMax(nums, start, end);

        TreeNode root = new TreeNode(maxV);
        int pos = findPosition(nums, root.val);

        root.left = buildTree(nums, start, pos - 1);
        root.right = buildTree(nums, pos + 1, end);

        return root;
    }

    private int getMax(int[] nums, int start, int end) {
        int max = nums[start];
        for (int i = start+1; i <= end; i++) {
            if (max < nums[i]) {
                max = nums[i];
            }
        }
        return max;
    }

    private int findPosition(int[] arr, int val) {
        int i;
        for (i = 0; i < arr.length; i++) {
            if (arr[i] == val) {
                return i;
            }
        }
        return -1;
    }

}
