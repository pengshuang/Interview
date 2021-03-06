package interview;

/**
 * Created by pengshuang on 17/2/9.
 * 字符串的统计字符串
 */
public class CountString {
    public static String getCountString(String str) {
        if (str == null || str.equals("")) {
            return "";
        }
        char[] chs = str.toCharArray();
        String res = String.valueOf(chs[0]);
        int num = 1;
        for (int i = 1; i < chs.length; i++){
            if (chs[i] != chs[i-1]) {
                res = concat(res, String.valueOf(num), String .valueOf(chs[i]));
                num = 1;
            } else {
                num++;
            }
        }
        return concat(res, String.valueOf(num), "");
    }

    public static String concat(String s1, String s2, String s3) {
        return s1  + "_" + s2 + (s3.equals("") ? s3 : "_" + s3);
    }

    public static void main(String[] args) {
        System.out.println(getCountString("aaabbbccc"));
    }
}
