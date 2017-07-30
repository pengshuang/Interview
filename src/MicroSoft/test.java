package MicroSoft;

import java.util.*;

public class test {

    private static double res;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            res = 0.0;
            int p = in.nextInt();
            int q = in.nextInt();
            int n = in.nextInt();
            TreeNode root = new TreeNode(0, 0, p, 100 - p, null, null, null);
            if (root.item < n) {
                createLeftTree(root, p, q, n);
            }
            if (root.item < n && root.rightP > 0) {
                createRightTree(root, p, q, n);
            }
            expectedNumber(root);

            System.out.printf("%.2f", res);
        }
    }

    private static void expectedNumber(TreeNode root) {
        if (isLeaf(root)) {
            double tmp = root.level;
            TreeNode node = root;
            while (node.parent != null) {
                tmp *= (node.isLeft ? node.parent.leftP : node.parent.rightP) / 100.0;
                node = node.parent;
            }
            res += tmp;
        } else {
            if (root.left != null) {
                expectedNumber(root.left);
            }
            if (root.right != null) {
                expectedNumber(root.right);
            }
        }
    }

    private static boolean isLeaf(TreeNode root) {
        return root.left == null && root.right == null;
    }

    private static void createLeftTree(TreeNode root, int p, int q, int n) {
        TreeNode left = new TreeNode(true, root.level + 1, root.item + 1, null, null, root);
        root.left = left;
        left.leftP = p / (1 << left.item);
        left.rightP = 100 - left.leftP;
        if (left.item < n) {
            createLeftTree(left, p, q, n);
        }
        if (left.item < n && left.rightP > 0) {
            createRightTree(left, p, q, n);
        }
    }

    private static void createRightTree(TreeNode root, int p, int q, int n) {
        TreeNode right = new TreeNode(false, root.level + 1, root.item, null, null, root);
        root.right = right;
        right.leftP = root.leftP + q > 100 ? 100 : root.leftP + q;
        right.rightP = 100 - right.leftP;
        if (right.item < n) {
            createLeftTree(right, p, q, n);
        }
        if (right.item < n && right.rightP > 0) {
            createRightTree(right, p, q, n);
        }
    }

    static class TreeNode {
        int level;
        int item;
        int leftP;
        int rightP;
        TreeNode left;
        TreeNode right;
        TreeNode parent;
        boolean isLeft;

        TreeNode(boolean isLeft, int level, int item, TreeNode left, TreeNode right, TreeNode parent) {
            super();
            this.isLeft = isLeft;
            this.level = level;
            this.item = item;
            this.left = left;
            this.right = right;
            this.parent = parent;
        }

        TreeNode(int level, int item, int leftP, int rightP, TreeNode left, TreeNode right, TreeNode parent) {
            super();
            this.level = level;
            this.item = item;
            this.leftP = leftP;
            this.rightP = rightP;
            this.left = left;
            this.right = right;
            this.parent = parent;
        }
    }
}
