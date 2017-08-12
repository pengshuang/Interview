package Netease;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class test {
    static class Point {
        int x;
        int y;
    }

    public static void main(String [] args){
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            int n = in.nextInt();
            Point[] arr = new Point[n];
            for (int i = 0; i < n; i++) {
                arr[i] = new Point();
                arr[i].x = in.nextInt();
            }
            for (int j = 0; j < n; j++) {
                arr[j].y = in.nextInt();
            }

            Arrays.sort(arr, new Comparator<Point>() {
                @Override
                public int compare(Point o1, Point o2) {
                    if (o1.x == o2.x)
                        return o1.y - o2.y;
                    return o1.x - o2.y;
                }
            });
            int[] diff = new int[n];
            int[] res = new int[n];
            diff[0] = 0;
            for (int i = 1; i < n; i++) {
                diff[i] = calculate(arr[i].x, arr[i].y, arr[i-1].x, arr[i-1].y);
            }

            for (int i = 1; i < res.length; i++) {
                res[i] = res[i-1] + diff[i];
            }

            for (int i = 0; i < res.length - 1; i++) {
                System.out.print(res[i] + " ");
            }
            System.out.println(res[diff.length-1]);
        }
    }
    
    private static int calculate(int x1, int y1, int x2, int y2) {
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }

    private static int getSum(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res += nums[i];
        }
        return res;
    }
}
