package Netease;

import java.util.Scanner;
import java.util.Stack;

public class Main2 {
    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);
        Stack<String> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        while (sc.hasNext()) {
            int n = sc.nextInt();
            while (n != 0) {
                if (n % 2 == 0) {
                    n = (n - 2) / 2;
                    stack.push("2");
                } else {
                    n = (n - 1) / 2;
                    stack.push("1");
                }
            }
            while (!stack.isEmpty()) {
                sb.append(stack.pop());
            }
            System.out.println(sb.toString());
        }

    }
}
