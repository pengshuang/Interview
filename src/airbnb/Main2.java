package airbnb;

import java.util.*;

public class Main2 {
    static void socialGraphs(int[] counts) {
        HashMap<Integer, TreeSet<Integer>> map = new HashMap<>();
        TreeSet<String> set = new TreeSet<>();
        for (int i = 0; i < counts.length; i++) {
            if (!map.containsKey(counts[i])) {
                map.put(counts[i], new TreeSet<Integer>());
                map.get(counts[i]).add(i);
            } else {
                map.get(counts[i]).add(i);
            }
        }
        Iterator<Map.Entry<Integer, TreeSet<Integer>>> entries = map.entrySet().iterator();
        while (entries.hasNext()) {
            Map.Entry<Integer, TreeSet<Integer>> entry = entries.next();
            TreeSet<Integer> value = entry.getValue();
            int size = entry.getKey();
            while (!value.isEmpty()) {
                StringBuilder item = new StringBuilder();
                for (int i = 0; i < size - 1; i++) {
                    item.append(value.pollFirst() + " ");
                    value.remove(i);
                }
                item.append(value.pollFirst());
                value.remove(0);
                set.add(item.toString());
            }
        }
        Iterator<String> itr = set.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
    }

    public static void main(String[] args) {
        int[] counts = new int[] {2,1,1,3,3,3,2};
        socialGraphs(counts);
    }
}
