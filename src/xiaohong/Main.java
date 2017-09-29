package xiaohong;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s = sc.nextLine();
            String s2 = check(s);
            if (s2.length() == 0 || !no(s2)) {
                System.out.println(-1);
                continue;
            }
            System.out.println(valid(s2));
        }
    }

    static String check(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (i < s.length() - 2 && s.substring(i, i+3).equals("RED")) {
                i = i + 2;
                continue;
            }
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }

    static String valid(String s) {
        String res = "0";
        int i = 0;
        int j = 0;
        while (i < s.length()) {
            while (j < s.length() && s.charAt(j) >= '0' && s.charAt(j) <= '9') {
                j++;
            }
            if (i != j) {
                while (s.charAt(i) == '0')
                    i++;
                if (j-i > res.length()) {
                    res = s.substring(i, j);
                } else if (j-i == res.length()
                        && compare(s.substring(i, j), res)) {
                    res = s.substring(i, j);
                }
            } else {
                i += 1;
                j = i;
                continue;
            }
            i = j + 1;
            j = i;
        }
        return res;
    }

    static boolean compare(String a, String b) {
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) > b.charAt(i))
                return true;
        }
        return false;
    }

    static boolean no(String a) {
        int i;
        for (i = 0; i < a.length(); i++) {
            if (a.charAt(i) <= '9' && a.charAt(i) >= '0')
                break;
        }
        return i < a.length();
    }
}
