package interview;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * Created by pengshuang on 17/2/10.
 * 生成窗口最大值数组
 */
public class MaxWindow {
    public static int[] getMaxWindow(int[] arr, int w) {
        if (arr == null || w < 1 || arr.length < w) {
            return null;
        }
        /*
            双端队列 qmax 中存放数组 arr 中的下标
         */
        LinkedList<Integer> qmax = new LinkedList<>();
        int[] res = new int[arr.length - w + 1];
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            while (!qmax.isEmpty() && arr[qmax.peekLast()] <= arr[i]) {
                // 将小的数从尾部弹出
                qmax.pollLast();
            }
            qmax.addLast(i);
            // 当前队头已过期
            if (qmax.peekFirst() == i - w) {
                qmax.pollFirst();
            }
            if (i >= w - 1) {
                res[index++] = arr[qmax.peekFirst()];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] res = getMaxWindow(new int[]{4,3,5,4,3,3,6,7}, 3);
        System.out.println(Arrays.toString(res));
    }
}
