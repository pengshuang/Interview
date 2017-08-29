package interview;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by pengshuang on 17/8/29.
 */
public class Find132pattern {
    public boolean find132pattern(int[] nums) {
        if (nums.length <= 2)
            return false;

        Stack<Integer> stack = new Stack<>();
        int post = Integer.MIN_VALUE;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] < post)
                return true;
            else {
                while (!stack.isEmpty() && nums[i] > stack.peek()) {
                    post = stack.peek();
                    stack.pop();
                }
            }
            stack.add(nums[i]);
        }
        return false;
    }
}
