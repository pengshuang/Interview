package interview;

import com.sun.glass.events.NpapiEvent;
import util.Node;

import java.util.HashMap;
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
        printList(n1);
//        getListLength(n1);
        reverseList(n1);
        printList(n5);
//        reGetKthNodeRec(n1, 1);
//        getMiddleNode(n1);
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

        while (head != null) {
            Node preCur = head;
            head = head.next;
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

    /**
     * 已知两个单链表pHead1 和pHead2 各自有序，把它们合并成一个链表依然有序
     * 这个类似归并排序。尤其注意两个链表都为空，和其中一个为空时的情况。只需要O（1）的空间。时间复杂度为O（max(len1, len2)）
     */

    public static Node mergeSortList(Node head1, Node head2) {
        if (head1 == null)
            return head2;
        if (head2 == null)
            return head1;

        Node mergeHead = null;
        if (head1.val < head2.val){
            mergeHead = head1;
            head1 = head1.next;
            mergeHead.next = null;
        } else {
            mergeHead = head2;
            head2 = head2.next;
            mergeHead.next = null;
        }

        Node mergeCur = mergeHead;
        while (head1 != null && head2 != null) {
            if (head1.val < head2.val){
                mergeCur.next = head1;
                head1 = head1.next;
                mergeCur = mergeCur.next;
                mergeCur.next = null;
            } else {
                mergeCur.next = head2;
                head2 = head2.next;
                mergeCur = mergeCur.next;
                mergeCur.next = null;
            }
        }
        if (head1 != null) {
            mergeCur.next = head1;
        } else {
            mergeCur.next = head2;
        }

        return mergeHead;
    }

    public static Node mergeSortedListRec(Node head1, Node head2) {
        if (head1 == null){
            return head2;
        }
        if (head2 == null) {
            return head1;
        }
        Node mergeHead = null;
        if (head1.val < head2.val) {
            mergeHead = head1;
            mergeHead.next = mergeSortedListRec(head1.next, head2);
        } else {
            mergeHead = head2;
            mergeHead.next = mergeSortedListRec(head1, head2.next);
        }
        return mergeHead;
    }

    public static boolean hasCycle(Node head) {
        Node fast = head;
        Node slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow){
                return true;
            }
        }
        return false;
    }

    public static boolean isIntersect(Node head1, Node head2) {
        if (head1 == null || head2 == null) {
            return false;
        }
        Node tail1 = head1;
        while (tail1.next != null) {
            tail1 = tail1.next;
        }
        Node tail2 = head2;
        while (tail2.next != null) {
            tail2 = tail2.next;
        }
        return tail1 == tail2;
    }

    public static Node getFirstCommonNode(Node head1, Node head2) {
        if (head1 == null || head2 == null) {
            return null;
        }
        int len1 = 1;
        Node tail1 = head1;
        while (tail1.next != null) {
            tail1 = tail1.next;
            len1++;
        }

        int len2 = 1;
        Node tail2 = head2;
        while (tail2.next != null) {
            tail2 = tail2.next;
            len2++;
        }

        if (tail1 != tail2) {
            return null;
        }

        Node n1 = head1;
        Node n2 = head2;

        if (len1 > len2){
            int k = len1 - len2;
            while (k != 0) {
                n1 = n1.next;
                k--;
            }
        } else {
            int k = len2 - len1;
            while (k != 0) {
                n2 = n2.next;
                k--;
            }
        }
        while (n1 != n2) {
            n1 = n1.next;
            n2 = n2.next;
        }
        return n1;
    }

    public static Node getFirstNodeInCycle(Node head) {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast)
                break;
        }
        if (fast == null || slow == null){
            return null;
        }
        //现在，相遇点离环的开始处的距离等于链表头到环开始处的距离，
        // 这样，我们把慢指针放在链表头，快指针保持在相遇点，然后
        // 同速度前进，再次相遇点就是环的开始处！
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }

    public static Node getFirstNodeInCycleHashMap(Node head) {
        HashMap<Node, Boolean> map = new HashMap<>();
        while (head != null) {
            if (map.get(head)) {
                return head;
            } else {
                map.put(head, true);
                head = head.next;
            }
        }
        return head;
    }

    public void delete(Node head, Node toDelete){
        if(toDelete == null){
            return;
        }
        if(toDelete.next != null){          // 要删除的是一个中间节点
            toDelete.val = toDelete.next.val;       // 将下一个节点的数据复制到本节点!
            toDelete.next = toDelete.next.next;
        }
        else{       // 要删除的是最后一个节点！
            if(head == toDelete){       // 链表中只有一个节点的情况
                head = null;
            }else{
                Node node = head;
                while(node.next != toDelete){   // 找到倒数第二个节点
                    node = node.next;
                }
                node.next = null;
            }
        }
    }
}
