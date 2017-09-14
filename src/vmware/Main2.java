package vmware;

/**
 * Created by pengshuang on 17/9/13.
 */
public class Main2 {

    static int calc(int m, int n) {
        if (m == 0) {
            return 1;
        } else if (m > n) {
            return 0;
        } else if (m == n) {
            return calc(n-1,n);
        }
        return calc(m-1,n) + calc(m,n-1);
    }

    public static void main(String[] args) {
        System.out.println(calc(1,1));
    }
}
