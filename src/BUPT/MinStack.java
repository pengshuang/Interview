package BUPT;

import java.util.Stack;

/**
 * Created by pengshuang on 17/8/30.
 */
public class MinStack {

    Stack<Integer> stack1;
    Stack<Integer> stack2;
    public MinStack() {
        // do initialize if necessary
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void push(int number) {
        // write your code here
        stack1.push(number);
        if (stack2.size() > 0) {
            if (number <= stack2.peek())
                stack2.push(number);
        } else {
            stack2.push(number);
        }
    }

    public int pop() {
        // write your code here
        if (stack1.size() == 0)
            return -1;
        int n = stack1.pop();
        if (stack2.size() > 0 && n == stack2.peek())
            stack2.pop();
        return n;
    }

    public int min() {
        // write your code here
        if (stack2.size() > 0)
            return stack2.peek();
        return -1;
    }
}
