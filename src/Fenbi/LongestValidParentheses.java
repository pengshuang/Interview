package Fenbi;

import java.util.HashMap;
import java.util.Stack;

public class LongestValidParentheses {

    static int longestValidParentheses(String s) {
        Stack<Character> stack = new Stack<>();
        HashMap<Character, Character> map = new HashMap<>();
        map.put('[', ']');
        map.put('{', '}');
        map.put('(', ')');
        int max = 0;
        int count = 0;
        for (int j = 0; j < s.length(); j++) {
            if (s.charAt(j) == '(' || s.charAt(j) == '[' || s.charAt(j) == '{')
                stack.push(s.charAt(j));
            else {
                if (!stack.isEmpty() && map.get(stack.peek()) != s.charAt(j)) {
                    stack.pop();
                    max = Math.max(max, count);
                    count = 0;
                }
                if (!stack.isEmpty() && map.get(stack.peek()) == s.charAt(j)) {
                    stack.pop();
                    count += 2;
                    continue;
                }
            }
            max = Math.max(max, count);
        }
        return max;
    }

    public static void main(String[] args) {
        String s = "[)[]]()()[]";
        System.out.println(longestValidParentheses(s));
    }
}
