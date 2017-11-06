package Huawei;

import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int[] nums = new int[5];
            for (int i = 0; i < 5; i++) {
                nums[i] = sc.nextInt();
            }
            solve(nums);
        }
    }

    static void solve(int[] nums) {
        Map<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }
        Iterator it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            System.out.print("[");
            for (int i = 0; i < (int)entry.getValue() - 1; i++) {
                System.out.print(entry.getKey() + ", ");
            }
            System.out.print(entry.getKey());
            System.out.println("]");
        }
    }
}

