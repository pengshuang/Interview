package test;

import java.util.Scanner;
public class Main5 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s = sc.nextLine();
            String[] arr = s.split("-");
            if (arr.length != 3){
                System.out.println("ERROR");
                continue;
            }
            if (arr[0].length() != 1 || arr[1].length() != 3 || arr[2].length() != 5){
                System.out.println("ERROR");
                continue;
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < arr.length; i++) {
                sb.append(arr[i]);
            }
            if (sb.length() != 9){
                System.out.println("ERROR");
                continue;
            }
            int num = Integer.parseInt(sb.toString());
            int count = 0;
            int index = 9;
            while (index > 0) {
                count += num % 10 * index;
                num /= 10;
                index--;
            }
            if (count % 11 < 10) {
                System.out.println(s + "-" + count%11);
            } else {
                System.out.println(s + "-" + "X");
            }
        }
    }
}
