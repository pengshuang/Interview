package interview;

import util.Node2;

/**
 * Created by pengshuang on 17/2/15.
 * 通过有序数组生成平衡二叉搜索树
 */

public class GenerateTreeFromSortedArray {
    public Node2 generate(int[] sortArr, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        Node2 head = new Node2(sortArr[mid]);
        head.left = generate(sortArr, start, mid - 1);
        head.right = generate(sortArr, mid + 1, end);
        return head;
    }

    public Node2 generateTree(int[] sortArr) {
        if (sortArr == null) {
            return null;
        }
        return generate(sortArr, 0, sortArr.length - 1);
    }
}
