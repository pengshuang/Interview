/**
 * Created by pengshuang on 17/9/24.
 */
public class RemoveDuplicate {
    public static char[] remove(char[] str) {
        if (str.length <= 1)
            return str;
        int i = 0;
        int j = i + 1;
        while (j < str.length) {
            if (str[i] != str[j]) {
                str[++i] = str[j++];
            } else {
                j++;
            }
        }
        char[] res = new char[i + 1];
        for (int k = 0; k <= i; k++) {
            res[k] = str[k];
        }
        return res;
    }

    public static void main(String [] args) {
        char[] str = new char[]{'a', 'a', 'c','c', 'd'};
        System.out.println(remove(str));
    }
}
