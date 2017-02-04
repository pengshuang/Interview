package interview;

import com.sun.glass.events.NpapiEvent;
import util.Node;

import java.util.Stack;

/**
 * Created by pengshuang on 17/2/4.
 */
public class LinkedListSummary {
    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
//        printList(n1);
//        getListLength(n1);
//        reverseList(n1);
//        printList(n4);
//        reGetKthNodeRec(n1, 1);
        getMiddleNode(n1);
    }

    private static void printList(Node head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static int getListLength(Node head) {
        if (head == null) {
            return 0;
        }

        int len = 0;
        Node cur = head;
        while (cur!=null){
            len += 1;
            cur = cur.next;
        }
        return len;
    }

    public static Node reverseList(Node head) {
        if (head == null || head.next == null)
            return head;

        Node newHead = null;
        Node cur = head;

        while (cur != null) {
            Node preCur = cur;
            cur = cur.next;
            preCur.next = newHead;
            newHead = preCur;
        }
        return newHead;
    }

    public static Node reverseListRec(Node head) {
        if (head == null || head.next == null)
            return head;

        Node reHead = reverseListRec(head.next);
        head.next.next = head;
        head.next = null;
        return reHead;
    }

    /**
     * 查找单链表中的倒数第K个结点（k > 0）
     * 最普遍的方法是，先统计单链表中结点的个数，然后再找到第（n-k）个结点。
     * 注意链表为空，k为0，k为1，k大于链表中节点个数时的情况 。
     * 时间复杂度为O（n）。代码略。 这里主要讲一下另一个思路，这种思路在其他题目中也会有应用。
     * 主要思路就是使用两个指针，先让前面的指针走到正向第k个结点
     * ，这样前后两个指针的距离差是k-1，之后前后两个指针一起向前走，
     * 前面的指针走到最后一个结点时，后面指针所指结点就是倒数第k个结点
     */
    public static Node reGetKthNode(Node head, int k) {
        if (k == 0 || head == null) {
            return null;
        }
        Node q = head;
        Node p = head;
        while (k > 1 && q != null) {
            q = q.next;
            k--;
        }

        if (k > 1 || q == null) {
            return null;
        }
        while (q.next != null) {
            p = p.next;
            q = q.next;
        }
        System.out.println(p.val);
        return p;
    }

    static int level = 0;
    public static void reGetKthNodeRec(Node head, int k) {
        if (head == null)
            return;

        reGetKthNodeRec(head.next, k);
        level++;
        if (level == k) {
            System.out.println(head.val);
        }
    }

    public static Node getMiddleNode(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node q = head;
        Node p = head;

        while (q.next != null) {
            q = q.next;
            p = p.next;
            if (q.next != null)
                q = q.next;
        }
        System.out.println(p.val);
        return p;
    }

    public static void reversePrintListStack(Node head) {
        Stack<Node> s = new Stack<>();
        Node cur = head;
        while (cur != null) {
            s.push(cur);
            cur = cur.next;
        }
        while (!s.empty()) {
            cur = s.pop();
            System.out.print(cur.val + " ");
        }
        System.out.println();
    }

    public static void reversePrintListRec(Node head) {
        if (head == null) {
            return;
        } else {
            reversePrintListStack(head.next);
            System.out.print(head.val + " ");
        }
    }


}
