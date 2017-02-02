package interview;

import java.util.Scanner;

/**
 * Created by pengshuang on 17/2/2.
 */
public class StrCarry {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            char[] str = in.nextLine().toCharArray();
            String res = carry(str);
            System.out.println(res);
        }
    }

    private static String carry(char[] ch){
       for(int i=1;i<ch.length;i++){
           int index = i-1;
           char temp = ch[i];
           if(Character.isUpperCase(temp)){
               continue;
           }
           while (index>=0 && Character.isUpperCase(ch[index])){
               ch[index+1] = ch[index];
               index--;
           }
           ch[index+1] = temp;
       }
       return String.valueOf(ch);
    }
}
