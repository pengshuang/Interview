package vmware;

/**
 * Created by pengshuang on 17/9/28.
 */
public class Test {
    public static void main(String[] args) {
        String a = "a";
        String b = "a";
        System.out.println(a == b);
        System.out.println(a.equals(b));

        String c = "00";
        String d = c.substring(1);
        System.out.println(d == "0");
    }
}
