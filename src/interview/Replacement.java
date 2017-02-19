package interview;

/**
 * Created by pengshuang on 17/2/19.
 */
public class Replacement {
    public static String replaceSpace(String str, int length) {
        // write code here
        char[] ch = str.toCharArray();
        int spaceCount = 0, newLength;
        for (int i = 0; i < length; i++) {
            if (ch[i] == ' ')
                spaceCount++;
        }
        newLength = length + spaceCount * 2;
        char[] ch2 = new char[newLength];
        ch2[newLength-1] = '\0';
        for (int i = length - 1; i >= 0; i--) {
            if (ch[i] == ' '){
                ch2[newLength - 1] = '0';
                ch2[newLength - 2] = '2';
                ch2[newLength - 3] = '%';
                newLength = newLength - 3;
            } else {
                ch2[newLength - 1] = ch[i];
                newLength = newLength - 1;
            }
        }
        return new String(ch2);
    }
    public static void main(String [] args){
        String a = "This is nowcoder";
        System.out.println(replaceSpace(a, a.length()));
    }
}
