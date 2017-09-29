package Baidu;

import java.util.*;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            sc.nextLine();
            int[][] nums = new int[n][8];
            for (int i = 0; i < n; i++) {
                 String[] line = sc.nextLine().split(" ");
                for (int j = 0; j < 8; j++) {
                    nums[i][j] = Integer.valueOf(line[j]);
                }
            }
            int k = sc.nextInt();

            PriorityQueue<Integer> pq = new PriorityQueue<>(k, new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o2 - o1;
                }
            });

            for (int i = 1; i <= k / 2; i++) {
                for (int j = 0; j < n; j++) {
                    int count = calc(i, nums[j]);
                    if (count > Math.pow(10, 17))
                        continue;
                    if (pq.size() < k) {
                        pq.offer(count);
                    } else {
                        if (pq.peek() > count) {
                            pq.poll();
                            pq.offer(count);
                        }
                    }
                }
            }
            System.out.println(pq.poll());
        }
    }
    static int calc(int n, int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res += nums[i] * Math.pow(n, nums.length-i-1);
        }
        return res;
    }
}
