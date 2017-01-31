package interview;

import java.util.Scanner;

/**
 * Created by pengshuang on 17/1/29.
 */
public class Xipai {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            int T = in.nextInt();
            for(int i=0; i<T; i++){
                int n = in.nextInt();
                int k = in.nextInt();
                int[] a = new int[2*n];
                for(int j=0;j<2*n;j++){
                    a[j] = in.nextInt();
                }
                Doshuffle(a,n,k);
            }
        }
    }
    private static void Doshuffle(int[] a, int n, int k){
        int[] b = new int[2*n];
        for(int i=0;i<2*n;i++){
            int index = i+1;
            for(int j=0;j<k;j++){
                if(index<=n)
                    index = 2*index - 1;
                else
                    index = 2*(index - n);
            }
            b[index-1] = a[i]; //完成k次洗牌后，将得到的新牌赋值给新的数组b
        }
        System.out.print(b[0]);
        for(int i=1;i<2*n;i++){
            System.out.print(" " + b[i]);
        }
        System.out.println();
    }
}
