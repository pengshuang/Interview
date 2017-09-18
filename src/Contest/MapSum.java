package Contest;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by pengshuang on 17/9/18.
 */
public class MapSum {
    HashMap<String, Integer> map;

    public MapSum() {
        map = new HashMap<>();
    }

    public void insert(String key, int val) {
        map.put(key, val);
    }

    public int sum(String prefix) {
        int res = 0;
        Iterator<Map.Entry<String, Integer>> entries = map.entrySet().iterator();
        while (entries.hasNext()) {
            Map.Entry<String, Integer> son = entries.next();
            if (son.getKey().startsWith(prefix))
                res += son.getValue();
        }
        return res;
    }
}
