package interview;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.jar.Pack200;

/**
 * Created by pengshuang on 17/2/4.
 */
public class BinaryReeSummary {
    /*
                 1
                / \
               2   3
              / \   \
             4  5   6
     */
    public static void main(String[] args) {
        TreeNode r1 = new TreeNode(1);
        TreeNode r2 = new TreeNode(2);
        TreeNode r3 = new TreeNode(3);
        TreeNode r4 = new TreeNode(4);
        TreeNode r5 = new TreeNode(5);
        TreeNode r6 = new TreeNode(6);

        r1.left = r2;
        r1.right = r3;
        r2.left = r4;
        r2.right = r5;
        r3.right = r6;

        int count = getNodeNumKthLevelRec(r1, 2);
        System.out.print(count);
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public static int getNodeNumRec(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            return getNodeNumRec(root.left) + getNodeNumRec(root.right) + 1;
        }
    }

    public static int getNodeNum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int count = 1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode cur = queue.remove();
            if(cur.left != null) {
                queue.add(cur.left);
                count++;
            }
            if(cur.right != null) {
                queue.add(cur.right);
                count++;
            }
        }
        return count;
    }

    public static int getDepthRec(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = getNodeNum(root.left);
        int rightDepth = getNodeNum(root.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }

    public static int getDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int depth = 0;
        int currentLevelNodes = 1;
        int nextLevelNodes = 0;

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()){
            TreeNode cur = queue.remove();
            currentLevelNodes--;
            if(cur.left != null){
                queue.add(cur.left);
                nextLevelNodes++;
            }
            if(cur.right != null){
                queue.add(cur.right);
                nextLevelNodes++;
            }
            if(currentLevelNodes == 0){
                depth++;
                currentLevelNodes = nextLevelNodes;
                nextLevelNodes = 0;
            }
        }
        return depth;
    }

    public static void preorderTraversalRec(TreeNode root) {
        if(root == null){
            return;
        }
        System.out.print(root.val + " ");
        preorderTraversal(root.left);
        preorderTraversal(root.right);
    }

    public static void preorderTraversal(TreeNode root) {
        if(root == null){
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()){
            TreeNode cur = stack.pop();
            System.out.print(cur.val + " ");

            if(cur.right != null){
                stack.push(cur.right);
            }

            if(cur.left != null){
                stack.push(cur.left);
            }
        }
    }

    public static void inorderTraversalRec(TreeNode root){
        if(root == null){
            return;
        }
        inorderTraversalRec(root.left);
        System.out.print(root.val + " ");
        inorderTraversalRec(root.right);
    }

    public static void inorderTraversal(TreeNode root){
        if(root == null){
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;

        while (true){
            while (cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            if(stack.isEmpty()){
                break;
            }
            cur = stack.pop();
            System.out.print(cur.val + " ");
            cur = cur.right;
        }
    }

    public static void postorderTraversalRec(TreeNode root) {
        if (root == null) {
            return;
        }

        postorderTraversalRec(root.left);
        postorderTraversalRec(root.right);
        System.out.print(root.val + " ");
    }

    public static void postorderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }

        Stack<TreeNode> s = new Stack<TreeNode>();      // 第一个stack用于添加node和它的左右孩子
        Stack<TreeNode> output = new Stack<TreeNode>();// 第二个stack用于翻转第一个stack输出

        s.push(root);
        while( !s.isEmpty() ){      // 确保所有元素都被翻转转移到第二个stack
            TreeNode cur = s.pop(); // 把栈顶元素添加到第二个stack
            output.push(cur);

            if(cur.left != null){       // 把栈顶元素的左孩子和右孩子分别添加入第一个stack
                s.push(cur.left);
            }
            if(cur.right != null){
                s.push(cur.right);
            }
        }

        while( !output.isEmpty() ){ // 遍历输出第二个stack，即为后序遍历
            System.out.print(output.pop().val + " ");
        }
    }

    public static void levelTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.push(root);

        while (!queue.isEmpty()){
            TreeNode cur = queue.pollFirst();
            System.out.print(cur.val + " ");
            if (cur.left != null) {
                queue.add(cur.left);
            }
            if (cur.right != null) {
                queue.add(cur.right);
            }
        }
    }

    public static void levelTraversalRec(TreeNode root) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
        dfs(root, 0, ret);
        System.out.print(ret);
    }

    private static void dfs(TreeNode root, int level, ArrayList<ArrayList<Integer>> ret) {
        if(root == null){
            return;
        }
        // 添加一个新的ArrayList表示新的一层
        if(level >= ret.size()){
            ret.add(new ArrayList<Integer>());
        }

        ret.get(level).add(root.val);   // 把节点添加到表示那一层的ArrayList里
        dfs(root.left, level+1, ret);       // 递归处理下一层的左子树和右子树
        dfs(root.right, level+1, ret);
    }

    /**
     * 求二叉树第K层的节点个数   递归解法：
     * （1）如果二叉树为空或者k<1返回0
     * （2）如果二叉树不为空并且k==1，返回1
     * （3）如果二叉树不为空且k>1，返回root左子树中k-1层的节点个数与root右子树k-1层节点个数之和
     *
     * 求以root为根的k层节点数目 等价于 求以root左孩子为根的k-1层（因为少了root那一层）节点数目 加上
     * 以root右孩子为根的k-1层（因为少了root那一层）节点数目
     *
     * 所以遇到树，先把它拆成左子树和右子树，把问题降解
     *
     */

    public static int getNodeNumKthLevelRec(TreeNode root, int k) {
        if (root == null || k < 1) {
            return 0;
        }
        if (k == 1) {
            return 1;
        }
        int numLeft = getNodeNumKthLevelRec(root.left, k - 1);
        int numRight = getNodeNumKthLevelRec(root.right, k - 1);
        return numLeft + numRight;
    }

    public static int getNodeNumKthLevel(TreeNode root, int k) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int i = 1;
        int currentLevelNodes = 1;
        int nextLevelNodes = 0;

        while (!queue.isEmpty() && i < k){
            TreeNode cur = queue.remove();
            currentLevelNodes--;
            nextLevelNodes++;

            if (cur.left != null){
                queue.add(cur.left);
                nextLevelNodes++;
            }

            if (cur.right != null){
                queue.add(cur.right);
                nextLevelNodes++;
            }

            if (currentLevelNodes == 0) {
                currentLevelNodes = nextLevelNodes;
                nextLevelNodes = 0;
                i++;
            }
        }
        return currentLevelNodes;
    }

    public static int getNodeNumLeafRec(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null){
            return 1;
        }
        return getNodeNumLeafRec(root.left) + getNodeNumLeafRec(root.right);
    }

    public static int getNodeNumLeaf(TreeNode root) {
        if (root == null){
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int leafNodes = 0;

        while (!queue.isEmpty()) {
            TreeNode cur = queue.remove();
            if(cur.left != null){
                queue.add(cur.left);
            }
            if(cur.right != null){
                queue.add(cur.right);
            }
            if(cur.left == null && cur.right == null){
                leafNodes++;
            }
        }
        return leafNodes;
    }

    public static boolean isAVLRec(TreeNode root) {
        if (root == null){
            return true;
        }
        if (Math.abs(getDepthRec(root.left) - getDepthRec(root.right)) > 1){
            return false;
        }
        return isAVLRec(root.left) && isAVLRec(root.right);
    }

    /**
     * 求二叉树的镜像 递归解法：
     * （1）如果二叉树为空，返回空
     * （2）如果二叉树不为空，求左子树和右子树的镜像，然后交换左子树和右子树
     */
    // 不破坏原来的树
    public static TreeNode mirrorRec(TreeNode root) {
        if (root == null)
            return null;
        TreeNode left = mirrorRec(root.left);
        TreeNode right = mirrorRec(root.right);

        root.left = right;
        root.right = left;
        return right;
    }
    // 破坏原来的树
    public static TreeNode mirrorCopyRec(TreeNode root) {
        if (root == null)
            return null;
        TreeNode newNode = new TreeNode(root.val);
        newNode.left = mirrorCopyRec(root.right);
        newNode.right = mirrorCopyRec(root.left);

        return newNode;
    }

    // 3. 判断两个树是否互相镜像
    public static boolean isMirrorRec(TreeNode r1, TreeNode r2){
        // 如果两个树都是空树，则返回true
        if(r1==null && r2==null){
            return true;
        }

        // 如果有一棵树是空树，另一颗不是，则返回false
        if(r1==null || r2==null){
            return false;
        }

        // 如果两个树都非空树，则先比较根节点
        if(r1.val != r2.val){
            return false;
        }

        // 递归比较r1的左子树的镜像是不是r2右子树 和
        // r1的右子树的镜像是不是r2左子树
        return isMirrorRec(r1.left, r2.right) && isMirrorRec(r1.right, r2.left);
    }

    public static void mirror(TreeNode root) {
        if(root == null){
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode cur = stack.pop();
            TreeNode tmp = cur.right;
            cur.right = cur.left;
            cur.left = tmp;

            if(cur.right != null){
                stack.push(cur.right);
            }
            if(cur.left != null){
                stack.push(cur.left);
            }
        }
    }

    public static TreeNode mirror2(TreeNode root){
        if (root == null){
            return null;
        }
        Stack<TreeNode> stack = new Stack<>();
        Stack<TreeNode> newStack = new Stack<>();
        stack.push(root);
        TreeNode newRoot = new TreeNode(root.val);
        newStack.push(newRoot);

        while (!stack.isEmpty()){
            TreeNode cur = stack.pop();
            TreeNode newCur = newStack.pop();

            if(cur.right != null){
                stack.push(cur.right);
                newCur.left = new TreeNode(cur.right.val);
                newStack.push(newCur.left);
            }
            if(cur.left != null){
                stack.push(cur.left);
                newCur.right = new TreeNode(cur.left.val);
                newStack.push(newCur.right);
            }
        }
        return newRoot;
    }
}