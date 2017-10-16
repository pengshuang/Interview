package VMware2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<List<Integer>, Integer> hashmap = new HashMap<>();
        for (int i = 0; i < 21; i++) {
            int n = (int)Math.pow(2, i);
            int first = n % 10;
            int last;
            while (n >= 10) {
                n = n / 10;
            }
            last = n;
            List<Integer> key = new ArrayList<>();
            key.add(first);
            key.add(last);
            hashmap.put(key, i);
        }
        while (sc.hasNext()) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            List<Integer> test = new ArrayList<>();
            test.add(a);
            test.add(b);
            System.out.println(hashmap.get(test));
        }
    }
}