package interview;

import java.util.HashMap;
import java.util.Map;

public class alibaba1 {
    public static void main(String[] args) {
        int[] inputs = {2, 5, 1, 1, 1, 1, 4, 3, 7, 5};
        int[] sums = new int[inputs.length];
        boolean flag = judge(sums, inputs);
        System.out.println(flag);

    }
    private static boolean judge(int[] sums, int[] inputs){
        Map<Integer, Integer> hashMap = new HashMap<>();
        int tmp = 0;
        for (int i = 0; i < inputs.length; i++) {
            tmp += inputs[i];
            sums[i] = tmp;
            hashMap.put(tmp, i);
        }

        for (int pos1 = 1; pos1 < inputs.length; pos1++) {
            int sum = sums[pos1] - inputs[pos1];
            if (hashMap.containsKey(sum + sums[pos1])) {
                int pos2 = hashMap.get(sum + sums[pos1]) + 1;
                if (pos2 < inputs.length && hashMap.containsKey(sum + sums[pos2])) {
                    int pos3 = hashMap.get(sum + sums[pos2]) + 1;
                    if (pos3 < inputs.length && hashMap.containsKey(sum + sums[pos3])) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
