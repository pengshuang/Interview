package MicroSoft;

/**
 * Created by pengshuang on 17/9/29.
 */
public class Main5 {
    static int solve(String text, String target) {
        int count = 0;
//        for (int i = 0; i < text.length() - target.length() + 1; i++) {
//            String sub = text.substring(i);
//            if (sub.startsWith(target) && !validSame(sub)){
//                count++;
//                i += target.length() - 1;
//            } else if (sub.startsWith(target) && validSame(sub)){
//                count++;
//            }
//        }
        for (int i = 0; i < text.length(); i++) {
            String sub = text.substring(i);
            if (sub.startsWith(target)) {
                count++;
            }
        }
        return count;
    }

    static boolean validSame(String s) {
        int count = 1;
        char pre = s.charAt(0);
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) != pre) {
                count++;
                break;
            }
        }
        return count == 1;
    }

    public static void main(String[] args) {
        String a = "TomTomTom";
        String b = "Tom";
        String a2 = "TiTiTTT";
        String b2 = "TiT";
        String a3 = "TTT";
        String b3 = "T";
        System.out.println(solve(a, b));
        System.out.println(solve(a2, b2));
        System.out.println(solve(a3, b3));
    }
}
