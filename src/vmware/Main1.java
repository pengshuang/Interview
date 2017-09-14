package vmware;

import java.util.Scanner;

public class Main1 {
    static int count(int n, int m) {
        int sum = 0;
        while (n != 0) {
            sum += n / m;
            n /= m;
        }
        return sum;
    }

    static int bin(int x) {
        int left = 1, right = 1000000000; //10^9
        int ret = -1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            int c = count(mid, 5);
            if (c == x) {
                ret = mid;
                right = mid - 1;
            }
            else if (c > x) {
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }
        return ret;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            int x = sc.nextInt();
            System.out.println(bin(x));
        }
    }

}
