package Netease;

import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int res = 0;
            int pre = n;
            while (n != 0) {
                res = res*10 + n%10;
                n /= 10;
            }
            System.out.println(res + pre);
        }
    }
}
