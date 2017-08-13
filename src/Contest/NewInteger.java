package Contest;

/**
 * Created by pengshuang on 17/8/13.
 */
public class NewInteger {
    public int newInteger(int n) {
        int res = 0, pow = 1;
        while (n > 0) {
            res += n % 9 * pow;
            pow *= 10;
            n /=  9;
        }
        return res;
    }
}
