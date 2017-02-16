package interview;

import java.util.Scanner;

/**
 * Created by pengshuang on 17/2/16.
 */
public class Cangbaotu {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        String t = in.nextLine();
        boolean flag = helper(s, t);
        if (flag){
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
        in.close();
    }

    private static boolean helper(String s, String t){
        if (t == null || t.length() == 0){
            return true;
        }
        for (int i=0,index=0;i<s.length();i++){
            if(s.charAt(i)==t.charAt(index)){
                index++;
                if(index==t.length()){
                    return true;
                }
            }
        }
        return false;
    }
}
