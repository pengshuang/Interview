package test;

import java.util.ArrayList;
import java.util.Scanner;

public class Main4 {

    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s1 = sc.nextLine();
            String s2 = sc.nextLine();
            ArrayList<Character> list = help(s1, s2);
            StringBuilder res1 = new StringBuilder();
            StringBuilder res2 = new StringBuilder();
            for (int i = 0; i < s1.length(); i++) {
                if (list.contains(s1.charAt(i)))
                    res1.append("_");
                else
                    res1.append(s1.charAt(i));
            }
            for (int i = 0; i < s2.length(); i++) {
                if (list.contains(s2.charAt(i)))
                    res2.append("_");
                else
                    res2.append(s2.charAt(i));
            }
            System.out.println(res1.toString());
            System.out.println(res2.toString());
        }
    }

        static ArrayList<Character> help(String s1, String s2) {
            boolean[] hash = new boolean[256];
            ArrayList<Character> res = new ArrayList<>();
            for (int i = 0; i < s1.length(); i++) {
                hash[s1.charAt(i)] = true;
            }
            for (int i = 0; i < s2.length(); i++) {
                if (hash[s2.charAt(i)]) {
                    res.add(s2.charAt(i));
                }
            }
            return res;

        }
}
