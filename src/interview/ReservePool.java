package interview;

/**
 * Created by pengshuang on 17/2/9.
 */
public class ReservePool {
    private static int rand(int max) {
        return (int) (Math.random() * max) + 1;
    }

    public int[] getKNumsRand(int k, int max) {
        if (max < 1 || k < 1)
            return null;
        int[] res = new int[Math.min(k, max)];
        for (int i = 0; i != res.length; i++) {
            res[i] = i + 1; // 前 k 个数直接进袋子
        }
        for(int i = k + 1; i < max + 1; i++) {
            if (rand(i) <= k) // 进不进 i 进不进袋子
                res[rand(k) - 1] = i; // i 随机替换掉袋子中的一个
        }
        return res;
    }
}
