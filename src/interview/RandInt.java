package interview;

/**
 * Created by pengshuang on 17/2/13.
 * 用 rand1To5 实现等概率随机产生 1 ~ 7 的随机函数 rang1To7
 * rand1To5(): 1,2,3,4,5
 * rand1To5() - 1: 0,1,2,3,4
 * (rand1To5() - 1)*5: 0,5,10,15,20
 * (rand1To5() - 1)*5 + (rand1To5() - 1): 0,1,2,3,...,23,24
 */
public class RandInt {

    /*
        等概率随机产生 1 ~ 5 的随机函数
     */
    public int rand1tTo5() {
        return (int) (Math.random() * 5) + 1;
    }

    public int rand1To7() {
        int num = 0;
        do {
            num = (rand1tTo5() - 1) * 5 + rand1tTo5() - 1;
        } while (num > 20);
        return num % 7 + 1;
    }

    /*
        给定一个以 p 概率产生 0,以 1 - p 概率产生 1 的随机函数 rand01p 如下:
        1. rand01() * 2 等概率随机产生 0 和 2
        2. rang01() * 2 + rand01() 等概率随机产生 0, 1, 2, 3
     */

    public int rand01p() {
        double p = 0.83;
        return Math.random() < p ? 0 : 1;
    }

    public int rand0To3() {
        return rand01p() * 2 + rand01p();
    }

    /*
        rand0To3() * 4 + rand0To3() 等概率的产生 0 ~ 15
     */

    public int rand1To6() {
        int num = 0;
        do {
            num = rand0To3() * 4 + rand0To3();
        } while (num > 11);
        return num % 6 + 1;
    }


    /*
        给定一个以等概率随机产生 1 ~ M 的随机函数 rand1ToM 如下:
        如果 M >= N, 直接进入筛过程; 如果 M < N, 先进入"插空过程,
        直到产生比 N 范围还大的随机范围之后,再进入筛过程
     */

    public int rand1ToM(int m) {
        return (int) (Math.random() * m) + 1;
    }

    public int rand1ToN(int n, int m) {
        int[] nMSys = getMSysNum(n - 1, m);
        int[] randNum = getRanMSysNumLessN(nMSys, m);
        return getNumFromMSysNum(randNum, m) + 1;
    }

    // 把 value 转成 m 进制数
    public int[] getMSysNum(int value, int m) {
        int[] res = new int[32];
        int index = res.length - 1;
        while (value != 0) {
            res[index--] = value % m;
            value = value / m;
        }
        return res;
    }

    public int[] getRanMSysNumLessN(int[] nMSys, int m) {
        int[] res = new int[nMSys.length];
        int start = 0;
        while (nMSys[start] == 0) {
            start++;
        }
        int index = start;
        boolean lastEqual = true;
        while (index != nMSys.length) {
            res[index] = rand1ToM(m) - 1;
            if (lastEqual) {
                if (res[index] > nMSys[index]) {
                    index = start;
                    lastEqual = true;
                    continue;
                } else {
                    lastEqual = res[index] == nMSys[index];
                }
            }
            index ++;
        }
        return res;
    }

    // 把 m 进制转换成十进制
    public int getNumFromMSysNum(int[] mSysNum, int m) {
        int res = 0;
        for (int i = 0; i != mSysNum.length; i++) {
            res = res * m + mSysNum[i];
        }
        return res;
    }
}
