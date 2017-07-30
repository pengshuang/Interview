package BUPT;

import java.util.Scanner;

public class Test3 {

    public static void main(String [] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            int n = in.nextInt();
            int p = in.nextInt();
            int q = in.nextInt();
            int[] health = new int[n];
            for (int i = 0; i < health.length; i++) {
                health[i] = in.nextInt();
            }
            int sum = getSum(health);
            int maxN = sum / (p + q);
            int flag = findMaxer(health, maxN);
            System.out.println(maxN - flag);

        }
    }

    public int getPower(int N, int P, int Q, int[] health){
        int sum = getSum(health);
        int maxN = sum / (P + Q);
        int flag = findMaxer(health, maxN);
        return maxN - flag;
    }

    private static int getSum(int[] health) {
        int res = 0;
        for (int i = 0; i < health.length; i++) {
            res += health[i];
        }
        return res;
    }

    private static int findMaxer(int[] health, int num) {
        int count = 0;
        for (int i = 0; i < health.length; i++) {
            if (health[i] < num){
                count += 1;
            }
        }
        return count - 1;
    }

}
