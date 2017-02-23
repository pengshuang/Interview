package interview;

import util.DoubleNode;
import util.Node;

/**
 * Created by pengshuang on 17/2/23.
 */
public class ReverseList {
    public Node reverseList(Node head) {
        Node pre = null;
        Node next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    public DoubleNode reverseList(DoubleNode head) {
        DoubleNode pre = null;
        DoubleNode next = null;
        while (head != null){
            next = head.next;
            head.next = pre;
            head.last = next;
            pre = head;
            head = next;
        }
        return pre;
    }

    /*
        1.先判断是否满足 1 <= from <= to <= N,如果不满足,则直接返回原理的头结点
        2.找到第from - 1个结点fPre和第to+1个结点tPos。fre是要反转部分的前一个结点,tPos
        是反转部分的后一个结点。把反转部分的先反转,然后正确的连接fPre和tPos。
        3.如果fre为null,说明反转部分是包含头结点的,则返回新的头结点,也就是没反转之前反转部分
        的最后一个结点,也是反转之后反转部分的第一个结点;如果fPre不为空，则返回旧的头结点
     */

    public Node reversePart(Node head, int from, int to){
        int len = 0;
        Node node1 = head;
        Node fPre = null;
        Node tPos = null;
        while (node1 != null) {
            len++;
            fPre = len == from - 1 ? node1 : fPre;
            tPos = len == to + 1 ? node1 : tPos;
            node1 = node1.next;
        }
        if (from > to || from < 1 || to > len){
            return head;
        }
        node1 = fPre == null ? head : fPre.next;
        Node node2 = node1.next;
        node1.next = tPos;
        Node next = null;
        while (node2 != tPos) {
            next = node2.next;
            node2.next = node1;
            node1 = node2;
            node2 = next;
        }
        if (fPre != null) {
            fPre.next = node1;
            return head;
        }
        return node1;
    }
}
