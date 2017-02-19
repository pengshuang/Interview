package interview;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by pengshuang on 17/2/19.
 */
public class Coder {
    public String[] findCoder(String[] A, int n) {
        Arrays.sort(A, new Comparator<String>() {
            public int compare(String s1, String s2) {
                s1 = s1.toLowerCase();
                s2 = s2.toLowerCase();
                return  countCoder(s2) - countCoder(s1);
            }
        });
        return A;
    }

    private int countCoder(String s) {
        int count = 0;
        for (int i = 0; i <= s.length() - 5; i++) {
            if ("coder".equals(s.substring(i, i + 5))) {
                count += 1;
            }
        }
        return count;
    }
}
