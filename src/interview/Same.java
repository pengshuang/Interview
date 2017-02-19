package interview;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created by pengshuang on 17/2/19.
 */
public class Same {
    public boolean checkSam(String stringA, String stringB) {
        // write code here
        char[] ch1 = stringA.toCharArray();
        char[] ch2 = stringB.toCharArray();
        if (ch1.length != ch2.length)
            return false;
        Arrays.sort(ch1);
        Arrays.sort(ch2);
        if (String.valueOf(ch1).equals(String.valueOf(ch2)))
            return true;
        else
            return false;
    }
}
