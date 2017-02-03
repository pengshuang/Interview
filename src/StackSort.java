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

}
