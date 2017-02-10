package interview;

import util.Node;
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

    /*
        利用递归函数,除此之外不使用任何容器的方法
        实现递归函数 process,process 的功能是将一棵搜索二叉树转换为一个结构有点特殊的有序双向链表。
        结构特殊指这个双向链表尾节点的 right 指针指向该双向链表的头结点。
     */

    public Node2 convert2(Node2 head) {
        if (head == null) {
            return null;
        }
        Node2 last = process(head);
        head = last.right;
        last.right = null;
        return head;
    }

    public Node2 process(Node2 head) {
        if (head == null) {
            return null;
        }
        Node2 leftE = process(head.left);
        Node2 rightE = process(head.right);
        Node2 leftS = leftE != null ? leftE.right : null;
        Node2 rightS = rightE != null ? rightE.right : null;
        if (leftE != null && rightE != null) {
            leftE.right = head;
            head.left = leftE;
            head.right = rightS;
            rightS.left = head;
            rightE.right = leftS;
            return rightE;
        } else if (leftE != null) {
            leftE.right = head;
            head.left = leftE;
            head.right = leftS;
            return head;
        } else if (rightE != null) {
            head.right = rightS;
            rightS.left = head;
            rightE.right = head;
            return rightE;
        } else {
            head.right = head;
            return head;
        }
    }
}
