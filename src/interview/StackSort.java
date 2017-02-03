package interview;

import java.util.Stack;

/**
 * Created by pengshuang on 17/2/3.
 * 对栈进行排序
 */
public class StackSort {
    public static Stack<Integer> sorted(Stack<Integer> s){
        Stack<Integer> r = new Stack<>();
        while (!s.isEmpty()){
            int tmp = s.pop();
            while (!r.isEmpty() && r.peek() > tmp){
                s.push(r.pop());
            }
            r.push(tmp);
        }
        return r;
    }

    public static Stack<Integer> mergeSort(Stack<Integer> s){
        if (s.size() <= 1)
            return s;
        Stack<Integer> left = new Stack<>();
        Stack<Integer> right = new Stack<>();

        int count = 0;
        while (s.size() != 0) {
            count++;
            if (count % 2 == 0)
                left.push(s.pop());
            else
                right.push(s.pop());
        }
        left = mergeSort(left);
        right = mergeSort(right);

        while (left.size()>0 || right.size()>0) {
            if (left.size() == 0)
                s.push(right.pop());
            else if (right.size() == 0)
                s.push(left.pop());
            else if (right.peek().compareTo(left.peek()) <= 0)
                s.push(left.pop());
            else
                s.push(right.pop());
        }

        Stack<Integer> reverseStack = new Stack<>();
        while (s.size() > 0){
            reverseStack.push(s.pop());
        }
        return reverseStack;
    }

}
