package BUPT;

/**
 * Created by pengshuang on 17/9/1.
 */
public class lianjia {
    static void initTargetHash(int []targethash, String Target) {
        for (char ch : Target.toCharArray()) {
            targethash[ch]++;
        }
    }
    static boolean valid(int []sourcehash, int []targethash) {

        for(int i = 0; i < 256; i++) {
            if(targethash[i] > sourcehash[i])
                return false;
        }
        return true;
    }
    static String minWindow(String Source, String Target) {
        int ans = Integer.MAX_VALUE;
        String minStr = "";

        int[] sourcehash = new int[256];
        int[] targethash = new int[256];

        initTargetHash(targethash, Target);
        int j = 0;
        for(int i = 0; i < Source.length(); i++) {
            while(!valid(sourcehash, targethash) && j < Source.length()) {
                sourcehash[Source.charAt(j)]++;
                j++;
            }
            if(valid(sourcehash, targethash)){
                if(ans > j - i) {
                    ans = j - i;
                    minStr = Source.substring(i, j);
                }
            }
            sourcehash[Source.charAt(i)]--;
        }
        return minStr;
    }

    public static void main(String[] args) {
        String target = "abc";
        String source = "acaabbcb";
        String newsource = source + source;
        System.out.println(minWindow(newsource, target));
    }

}
