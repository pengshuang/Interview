package MicroSoft;

/**
 * Created by pengshuang on 17/9/29.
 */
public class Main7 {
    static int KAndyman(int numOfCandies, int subSetSize, int[] sweetnessVal)
    {
        int res = 0;
        for(int i = 0; i < numOfCandies-subSetSize + 1; i++) {
            int tmp = sweetnessVal[i];
            for (int j = 1; j < subSetSize; j++) {
                tmp &= sweetnessVal[i+j];
            }
            res = Math.max(tmp, res);
        }
        return res;
    }

    public static void main(String [] args) {
        System.out.println(KAndyman(7, 3, new int[]{1,3,5,8,10,12,13}));
    }
}
