package interview;

/**
 * Created by pengshuang on 17/2/19.
 */
public class Zipper {
    public static String zipString(String iniString) {
        // write code here
        char[] ch = iniString.toCharArray();
        char index = ch[0];
        StringBuffer sb = new StringBuffer();
        int count = 1;
        for (int i = 1; i < ch.length; i++) {
            if (ch[i] == index){
                count++;
            } else if (ch[i] != index){
                sb.append(index);
                sb.append(count);
                index = ch[i];
                count = 1;
            }
        }
        sb.append(index);
        sb.append(count);
        if (sb.length() < iniString.length())
            return new String(sb);
        else
            return iniString;
    }

    public static void main(String [] args){
        String a = "welcometonowcoderrrrr";
        System.out.println(zipString(a));
    }
}
