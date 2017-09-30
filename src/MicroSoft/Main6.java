package MicroSoft;

/**
 * Created by pengshuang on 17/9/29.
 */
public class Main6 {
    static int exercise(int num, int actions, int position, int[][] act)
    {
        int[] nums = new int[num];
        for (int i = 1; i <= num; i++) {
            nums[i-1] = i;
        }
        for (int i = 0; i < act.length; i++) {
            int start = act[i][0] - 1;
            int end = act[i][1] - 1;
            reverse(nums, start, end);
        }
        return nums[position-1];
    }

    static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
            start++;
            end--;
        }
    }

    public static void main(String [] args) {
        System.out.println(exercise(10, 2, 1, new int[][]{{1 ,5}, {6, 10}}));
        System.out.println(exercise(10, 2, 10, new int[][]{{5 ,9}, {2, 3}}));
    }
}
