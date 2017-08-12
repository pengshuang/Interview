package interview;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by pengshuang on 17/8/12.
 */

class ListNode {
    int val;
    ListNode next;
    ListNode(int x){
        val = x;
    }
}
public class MergeKlists {

    public ListNode mergeKLists(List<ListNode> lists) {
        if (lists == null || lists.size() == 0)
            return null;

        PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.size(), new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        for(ListNode node : lists) {
            if (node != null){
                queue.offer(node);
            }
        }

        while (!queue.isEmpty()) {
            tail.next = queue.poll();
            tail = tail.next;

            if (tail.next != null)
                queue.offer(tail.next);
        }
        return dummy.next;
    }
}
