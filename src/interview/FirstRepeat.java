package interview;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by pengshuang on 17/2/19.
 */
public class FirstRepeat {
    public char findFirstRepeat(String A, int n) {
        char[] ch = A.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (map.containsKey(ch[i])){
                return ch[i];
            }else {
                map.put(ch[i], 1);
            }
        }
        return ch[n-1];
    }
}
