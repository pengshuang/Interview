import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by pengshuang on 17/8/31.
 */



public class MergeKList {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    public ListNode mergeKLists(List<ListNode> lists) {
        if (lists.size() == 0)
            return null;
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        PriorityQueue<ListNode> pq = new PriorityQueue<>(lists.size(), new Comparator<ListNode>() {
            public int compare(ListNode left, ListNode right) {
                return left.val - right.val;
            }

        });
        for (int i = 0; i < lists.size(); i++) {
            if(lists.get(i) != null) {
                pq.offer(lists.get(i));
            }
        }
        while (!pq.isEmpty()) {
            ListNode node = pq.poll();
            head.next = node;
            head = head.next;
            if (node.next != null)
                pq.offer(node.next);
        }
        return dummy.next;
    }
}
