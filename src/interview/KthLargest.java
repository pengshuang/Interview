package interview;

import java.util.PriorityQueue;

/**
 * Created by pengshuang on 17/8/29.
 */
public class KthLargest {
    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int n : nums) {
            if (pq.size() <= k)
                pq.offer(n);
            else {
                if (n > pq.peek()){
                    pq.poll();
                    pq.offer(n);
                }
            }
        }
        return pq.peek();
    }
}
