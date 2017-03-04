package interview;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by pengshuang on 17/3/4.
  当数据总数为偶数时，新加入的元素，应当进入小根堆
 （注意不是直接进入小根堆，而是经大根堆筛选后取大根堆中最大元素进入小根堆）
 1.新加入的元素先入到大根堆，由大根堆筛选出堆中最大的元素
 2. 筛选后的大根堆中的最大元素进入小根堆

  数据总数为奇数时，新加入的元素，应当进入大根堆
 （注意不是直接进入大根堆，而是经小根堆筛选后取小根堆中最大元素进入大根堆）
 1.新加入的元素先入到小根堆，由小根堆筛选出堆中最小的元素
 2.筛选后的小根堆中的最小元素进入小根堆
 */
public class GetMedian {
    private int count = 0;
    private PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    private PriorityQueue<Integer> maxHeap = new PriorityQueue<>(15, new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    });

    public void Insert(Integer num) {
        if (count % 2 == 0){
            maxHeap.offer(num);
            int filteredMaxNum = maxHeap.poll();
            minHeap.offer(filteredMaxNum);
        } else {
            minHeap.offer(num);
            int filteredMaxNum = minHeap.poll();
            maxHeap.offer(filteredMaxNum);
        }
        count += 1;
    }

    public Double GetMedian() {
        if (count % 2 == 0) {
            return new Double((minHeap.peek() + maxHeap.peek())) / 2;
        } else {
            return new Double(minHeap.peek());
        }
    }

    public static void main(String [] args){
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(15, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        maxHeap.offer(1);
        maxHeap.offer(2);
        maxHeap.offer(3);
        int top = maxHeap.peek();
        System.out.println(top);

        minHeap.offer(1);
        minHeap.offer(2);
        minHeap.offer(3);
        int top2 = minHeap.peek();
        System.out.println(top2);

    }
}
