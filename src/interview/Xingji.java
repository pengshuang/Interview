package interview;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by pengshuang on 17/2/15.
 */
public class Xingji {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long h = in.nextLong();
        long start = 0, end = h;
        long res = 0;
        BigInteger rh = BigInteger.valueOf(h);
        while (start + 1 < end) {
            long mid = (start + end) / 2;
            BigInteger r = BigInteger.valueOf(mid);
            BigInteger r1 = BigInteger.valueOf(mid + 1);

            r = r.multiply(r1);
            if (r.compareTo(rh) <= 0){
                start = mid;
                res = mid;
            } else {
                end = mid;
            }
        }
        System.out.println(res);
    }
}

/*

h=input()
head=0
tail=pow(10,9)
while head<tail:
    mid=(head+tail)/2
    i=mid
    if i+i*i>h:
        tail=mid
    else:
        head=mid+1
print head-1

 */