package interview;

import java.util.Arrays;

public class ReverseStringII {
    public static String reverseStr(String s, int k){
        char[] ch = s.toCharArray();
        int i = 0;
        int n = s.length();
        while (i < n) {
            int j = Math.min(i + k - 1, n - 1);
            reverse(ch, i, j);
            i += 2*k;
        }
        return String.valueOf(ch);
    }

    private static void reverse(char[] ch, int start, int end){
        while (start < end){
            char temp;
            temp = ch[start];
            ch[start] = ch[end];
            ch[end] = temp;
            start += 1;
            end -= 1;
        }
    }

    public static void main(String [] args) {
        String s = "abcdefg";
        int k = 2;
        System.out.println(reverseStr(s, k));
    }
}
