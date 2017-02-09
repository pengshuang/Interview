package interview;

import java.util.HashMap;
import java.util.logging.Handler;

/**
 * Created by pengshuang on 17/2/9.
 * 数组中的最长连续子序列
 * 给定 arr = [100,4,200,1,3,2],最长的连续序列为[1,2,3,4],所以返回4;
 */
public class LongestConsecutive {
    public int longestConsecutive(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int max = 1;
        /*
        生成 HashMap 的 key 代表遍历过的某个数,value 代表 key 这个数所在的最长连续序列的长度
         */
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (!map.containsKey(arr[i])) {
                map.put(arr[i], 1);
                if (map.containsKey(arr[i] - 1)) {
                    max = Math.max(max, merge(map, arr[i] - 1, arr[i]));
                }
                if (map.containsKey(arr[i] + 1)) {
                    max = Math.max(max, merge(map, arr[i], arr[i] + 1));
                }
            }
        }
        return max;
    }

    public int merge(HashMap<Integer, Integer> map, int less, int more) {
        int left = less - map.get(less) + 1;
        int right = more + map.get(more) - 1;
        int len = right - left + 1;
        map.put(left, len);
        map.put(right, len);
        return len;
    }
}
