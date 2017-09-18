package Contest;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class FrequencySort {
    public String frequencySort(String s) {
        final HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i)))
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
            else
                map.put(s.charAt(i), 1);
        }

        PriorityQueue<Character> pq = new PriorityQueue<>(s.length(), new Comparator<Character>() {
            @Override
            public int compare(Character c1, Character c2) {
                return map.get(c2) - map.get(c1);
            }
        });

        for(char i : map.keySet()) {
            pq.offer(i);
        }

        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()){
            char c = pq.poll();
            for (int i = 0; i < map.get(c); i++) {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
