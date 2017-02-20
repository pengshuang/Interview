package interview;

import java.util.Scanner;

public class MaxScore {
    public static void main(String [] args){
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            int n = in.nextInt();
            int m = in.nextInt();
            int[] score = new int[n];
            for (int i = 0; i < n; i++) {
                score[i] = in.nextInt();
            }
            in.nextLine();
            for (int i = 0; i < m; i++) {
                String[] cmd = in.nextLine().split(" ");
                if (cmd[0].equals("Q")){
                    int start = Integer.parseInt(cmd[1]) - 1;
                    int end = Integer.parseInt(cmd[2]) - 1;
                    if (start < end){
                        int maxV = getMaxV(score, start, end);
                        System.out.println(maxV);
                    }else {
                        int maxV = getMaxV(score, end, start);
                        System.out.println(maxV);
                    }

                } else {
                    int index = Integer.parseInt(cmd[1]) - 1;
                    score[index] = Integer.parseInt(cmd[2]);
                }
            }
        }
    }

    private static int getMaxV(int[] score, int start, int end){
        int temp = score[start];
        for (int i = start + 1; i <= end; i++) {
            if (score[i] > temp){
                temp = score[i];
            }
        }
        return temp;
    }
}
