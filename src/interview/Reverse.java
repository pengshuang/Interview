package interview;

import java.util.*;

public class Reverse {
    public static String reverseString(String str) {
        int start = 0;
        int end = str.length() - 1;
        char[] ch = str.toCharArray();
        while (start < end){
            char temp = ch[start];
            ch[start] = ch[end];
            ch[end] = temp;
            start++;
            end--;
        }
        return String.valueOf(ch);
    }

    public static void main(String [] args){
        String a = "This is nowcoder";
        System.out.println(reverseString(a));
    }
}
