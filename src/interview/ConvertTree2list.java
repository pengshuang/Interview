package interview;

import util.Node2;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by pengshuang on 17/2/10.
 * 将搜索二叉树转换成双向链表
 */

public class ConvertTree2list {
    public Node2 convert(Node2 head) {
        Queue<Node2> queue = new LinkedList<>();
        inOrderToQueue(head, queue);
        if (queue.isEmpty()) {
            return head;
        }
        head = queue.poll();
        Node2 pre = head;
        pre.left = null;
        Node2 cur = null;
        while (!queue.isEmpty()) {
            cur = queue.poll();
            pre.right = cur;
            cur.left = pre;
            pre = cur;
        }
        pre.right = null;
        return head;
    }

    // 用队列收集二叉树中序遍历的结果
    public void inOrderToQueue(Node2 head, Queue<Node2> queue) {
        if (head == null) {
            return;
        }
        inOrderToQueue(head.left, queue);
        queue.offer(head);
        inOrderToQueue(head.right, queue);
    }
}
