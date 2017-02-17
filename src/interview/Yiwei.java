package interview;

import java.util.Scanner;

/**
 * Created by pengshuang on 17/2/17.
 */
public class Yiwei {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            String str = in.nextLine();
            char[] ch = str.toCharArray();
            for (int i = 0; i < ch.length; i++) {
                for (int j = 0; j < ch.length - 1 - i; j++) {
                    if ((ch[j] >= 'A' && ch[j] <= 'Z')
                            && (ch[j+1] < 'A' || ch[j+1] > 'Z')){
                        char c = ch[j];
                        ch[j] = ch[j+1];
                        ch[j+1] = c;
                    }
                }
            }
            System.out.println(String.valueOf(ch));
        }
    }

    private static void swap(char[] ch, int start, int end){
        char temp = ch[end];
        ch[end] = ch[start];
        ch[start] = temp;
    }
}
