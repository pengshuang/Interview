package Netease;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s = sc.nextLine();
            Set<String> set = new HashSet<>();
            for (int i = 0; i < s.length(); i++) {
                String w = s.substring(0, i) + s.substring(i + 1);
                for(int j = 0; j < s.length() - 1; j++) {
                    String u = w.substring(0, j) + s.charAt(i) + w.substring(j);
                    int tmp = 0;
                    for(int k = 0; k < s.length(); k++) {
                        tmp += (u.charAt(k) == '(' ? 1 : -1);
                        if(tmp < 0) {
                            break;
                        }
                    }
                    if(tmp == 0) {
                        set.add(u);
                    }
                }
            }
            System.out.println(set.size());
        }
    }
}
