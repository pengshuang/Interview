package MicroSoft;


import java.util.*;

/**
 * Created by pengshuang on 17/9/29.
 */
public class Main8 {

    static String demoTestId(int numOfEmp, int numOfSub, int[][] idList)
    {
        Arrays.sort(idList, new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0])
                    return o1[1] - o2[1];
                return o1[0] - o2[0];
            }
        });

        StringBuilder sb = new StringBuilder();
        HashMap<Integer, ArrayList<Integer>> relation = new HashMap<>();

        for (int i = 0; i < idList.length; i++) {
             int father = idList[i][0];
             int son = idList[i][1];
             if (!relation.containsKey(father)) {
                 relation.put(father, new ArrayList<Integer>());
                 relation.get(father).add(son);
             } else {
                 relation.get(father).add(son);
             }
        }
        int start = idList[0][0];
        LinkedList<Integer> queue = new LinkedList<>();
        HashMap<Integer, String > map = new HashMap<>();
        queue.add(start);
        map.put(1, "0");
        sb.append("0");
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int key = queue.poll();
                if (relation.containsKey(key) && !relation.get(key).isEmpty()) {
                    for (int k = 0; k < relation.get(key).size(); k++) {
                        queue.offer(relation.get(key).get(k));
                        sb.append(map.get(key)).append(k);
                        map.put(relation.get(key).get(k), map.get(key) + k);
                    }
                }
            }
        }
        return sb.toString();
    }

    public static void main(String [] args) {
        System.out.println(demoTestId(7, 6, new int[][]{{1,3},{2,4},{3,7},{2,5},{1,2},{3,6}}));
        System.out.println(demoTestId(3, 2, new int[][]{{1,3},{1,2}}));
    }
}
