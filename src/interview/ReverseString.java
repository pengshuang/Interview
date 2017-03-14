package interview;

/**
 * Created by pengshuang on 17/3/8.
 */
public class ReverseString {
    public String reverseString(String s) {
        char[] ch1 = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = ch1.length - 1; i >= 0; i--) {
            sb.append(ch1[i]);
        }
        return sb.toString();
    }
}
