package BUPT;

import java.util.*;

public class Test2 {
    public static void main(String [] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int start = 0;
        while (start < n){
            int num = in.nextInt();
            System.out.println(countNum(num));

        }
    }

   private static int countNum(int num){
       int count = 0;
       if (num == 1){
           count += 1;
       }
       count += countNum(num - 1);
       return count;
   }
}
