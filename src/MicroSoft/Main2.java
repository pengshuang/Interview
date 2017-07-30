package MicroSoft;

import java.util.*;

public class Main2 {
    static class TreeNode {
        double temp = 1.0;
        TreeNode left;
        TreeNode right;
        int flag = 0;
        int count = 0;
        int step = 0;
        int last = 0;
        int val = 0;
    }

    static double result = 0.0;

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int p = in.nextInt();
        int q = in.nextInt();
        int n = in.nextInt();
        TreeNode root = new TreeNode();
        dfs(root, p, q, n);
        System.out.println(String.format("%.2f", result));


    }

    private static void dfs(TreeNode r, int p, int q, int n) {
        if (r != null) {
            if (r.count == n) {
                result += r.step * r.temp;
                return;
            }
            if (r.flag == 0) {
                r.val = p;
            }
            else if(r.flag == 1){
                r.val = (int) Math.floor(p / Math.pow(2, r.count));
            } else {
//                r.val = (r.last + q) >= 100 ? 100 : (r.last + q);
                if (r.last + q >= 100){
                    r.val = 100;
                }else {
                    r.val = r.last + q;
                }
            }

            if (r.val > 0) {
                TreeNode left = new TreeNode();
                left.flag = 1;
                left.last = r.val;
                left.count = r.count + 1;
                left.step = r.step + 1;
                left.temp = (r.val * r.temp) / 100;
                r.left = left;
            }

            if (r.val < 100) {
                TreeNode right = new TreeNode();
                right.flag = -1;
                right.last =  r.val;
                right.count = r.count;
                right.step = r.step + 1;
                right.temp = (r.temp * (100 - r.val) / 100);
                r.right = right;
            }
        }
        if (r.left != null) {
            dfs(r.left, p, q, n);
        }
        if (r.right != null) {
            dfs(r.right, p, q, n);
        }
    }
}
