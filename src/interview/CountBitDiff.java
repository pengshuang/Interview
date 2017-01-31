package interview;

/**
 * Created by pengshuang on 17/1/30.
 */
public class CountBitDiff {
    public int countBitDiff(int m, int n) {
        int dif = m^n;
        int cnt = 0;
        while (dif!=0){
            dif = dif&(dif-1);
            cnt++;
        }
        return cnt;
    }
}

