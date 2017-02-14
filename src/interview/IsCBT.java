package interview;

import util.Node2;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by pengshuang on 17/2/14.
 * 判断一棵树是不是完全二叉树
 * 1. 按层遍历二叉树,从每层的左边向右边依次遍历所有的节点
 * 2. 如果当前节点有右孩子,但没有左孩子,直接返回 false
 * 3. 如果当前节点并不是左右孩子全有,那之后的节点必须都为叶结点,否则返回 false
 * 4. 遍历过程如果不返回 false,遍历结束返回 true
 */

public class IsCBT {
    public boolean isCBT(Node2 head) {
        if (head == null)
            return true;
        Queue<Node2> queue = new LinkedList<Node2>();
        boolean leaf = false;
        Node2 l = null;
        Node2 r = null;
        queue.offer(head);
        while (!queue.isEmpty()) {
            head = queue.poll();
            l = head.left;
            r = head.right;
            if ((leaf && (l != null || r != null)) || (l == null && r !=null)) {
                return false;
            }
            if (l != null) {
                queue.offer(l);
            }
            if (r != null) {
                queue.offer(r);
            }
            else {
                leaf = true;
            }
        }
        return true;
    }

}
