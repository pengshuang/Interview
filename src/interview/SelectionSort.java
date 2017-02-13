package interview;

import util.Node;

/**
 * Created by pengshuang on 17/2/13.
 * 单链表的选择排序
 */

public class SelectionSort {
    public static Node selectionSort (Node head) {
        Node tail = null;
        Node cur = head;
        Node smallPre = null;
        Node small = null;
        while (cur != null) {
            small = cur;
            /*
                每次在未排序的部分中找到最小值的节点,
                然后把这个节点从未排序的链表中删除,
                删除的过程当然要保证未排序部分的链表在结构上不至于断开。
             */
            smallPre = getSmallestPreNode(cur);
            if (smallPre != null) {
                small = smallPre.next;
                smallPre.next = small.next;
            }
            cur = cur == small ? cur.next : cur;
            if (tail == null) {
                head = small;
            } else {
                tail.next = small;
            }
            tail = small;
        }
        return head;
    }

    public static Node getSmallestPreNode(Node head) {
        Node smallPre = null;
        Node small = head;
        Node pre = head;
        Node cur = head.next;
        while (cur != null) {
            if (cur.val < small.val) {
                smallPre = pre;
                small = cur;
            }
            pre = cur;
            cur = cur.next;
        }
        return smallPre;
    }
}
