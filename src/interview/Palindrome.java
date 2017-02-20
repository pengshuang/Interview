package interview;

import util.Node;

import java.util.Stack;

public class Palindrome {
    public boolean isPalindrome1(Node head) {
        Stack<Node> stack = new Stack<>();
        Node cur = head;
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }
        while (head != null) {
            if (head.val != stack.pop().val) {
                return false;
            }
            head = head.next;
        }
        return true;
    }

    public String longestPalindrome(String s) {
        if(s==null) return null;
        String result = s.substring(0, 1);
        for(int i=1;i<s.length();i++){
            String p1 = findPalindrome(s,i-1,i);
            String p2 = findPalindrome(s,i-1,i+1);

            String longer = p1.length() > p2.length() ? p1:p2;
            result = longer.length() > result.length() ? longer:result;
        }
        return result;
    }

    private String findPalindrome(String s, int start, int end){
        while (start >= 0 && end <= s.length()-1){
            if(s.charAt(start) != s.charAt(end))
                break;
            start--;
            end++;
        }
        return s.substring(start+1,end);
    }

    /*
        也是利用栈结构,
        只压入一半的节点即可。
     */
    public boolean isPalindrome2(Node head) {
        if (head == null || head.next == null){
           return true;
        }
        Node right = head.next;
        Node cur = head;
        while (cur.next != null && cur.next.next != null){
            right = right.next;
            cur = cur.next.next;
        }
        Stack<Node> stack = new Stack<>();
        while (right != null){
            stack.push(right);
            right = right.next;
        }
        while (!stack.isEmpty()) {
            if (head.val != stack.pop().val) {
                return false;
            }
            head = head.next;
        }
        return true;
    }
}
