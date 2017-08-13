package Contest;

import java.util.*;

/**
 * Created by pengshuang on 17/8/13.
 */
public class FindClosestElements {
    public static List<Integer> findClosestElements(List<Integer> arr, int k, int x) {
        List<Integer> less = new ArrayList<>(), greater = new ArrayList<>(),
                lessResult = new ArrayList<>(), greaterResult = new ArrayList<>();

        for (Integer i : arr) {
            if (i <= x)
                less.add(i);
            else
                greater.add(i);
        }

        Collections.reverse(less);
        int i = 0, j = 0, n = less.size(), m = greater.size();
        for (int size = 0; size < k; size++) {
            if (i < n && j < m) {
                if (Math.abs(less.get(i) - x) <= Math.abs(greater.get(j) - x))
                    lessResult.add(less.get(i++));
                else
                    greaterResult.add(greater.get(j++));
            }
            else if (i < n)
                lessResult.add(less.get(i++));
            else
                greaterResult.add(greater.get(j++));
        }

        Collections.reverse(lessResult);
        lessResult.addAll(greaterResult);
        return lessResult;
    }

    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>(Arrays.asList(1,2,3,4,5));
        System.out.print(findClosestElements(arr, 4, -1));
    }
}
