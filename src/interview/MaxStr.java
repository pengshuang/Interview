package interview;

import java.util.*;

public class MaxStr {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String str = sc.nextLine();
            char maxStr = str.charAt(0);
            int count = 0;
            for (int i = 1; i < str.length(); i++) {
                if (maxStr < str.charAt(i)){
                    maxStr = str.charAt(i);
                }
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == maxStr) {
                    sb.append(str.charAt(i));
                    sb.append("(max)");
                }else{
                    sb.append(str.charAt(i));
                }
            }
            System.out.println(sb.toString());
        }
    }

}
