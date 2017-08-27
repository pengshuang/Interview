package BUPT;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

/**
 * Created by pengshuang on 17/8/26.
 */
public class TestDeque {

    public static void main(String[] args) {
        Deque<Integer> q = new ArrayDeque<>();
        q.offer(1);
        q.offer(2);
        System.out.println(q.peek());
        System.out.println(q.pollLast());
        ArrayList<Integer> a = new ArrayList<Integer>(0);
        System.out.println(a);
    }
}
