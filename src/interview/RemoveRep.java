package interview;

import util.Node;

import java.util.HashSet;

/**
 * Created by pengshuang on 17/2/9.
 * 删除无序单链表中值重复出现的节点
 */


public class RemoveRep {
    public void removeRep1 (Node head) {
        if (head == null) {
            return;
        }
        HashSet<Integer> set = new HashSet<>();
        Node pre = head;
        Node cur = head.next;
        set.add(head.val);
        while (cur != null) {
            if (set.contains(cur.val)) {
                pre.next = cur.next;
            } else {
                set.add(cur.val);
                pre = cur;
            }
            cur = cur.next;
        }
    }
//     不用额外空间的做法
    public void removeRep2 (Node head) {
        Node cur = head;
        Node pre = null;
        Node next = null;

        while (cur != null) {
            pre = cur;
            next = cur.next;
            while (next != null) {
                if (cur.val == next.val) {
                    pre.next = next.next;
                } else {
                    pre = next;
                }
                next = next.next;
            }
            cur = cur.next;
        }
    }
}
