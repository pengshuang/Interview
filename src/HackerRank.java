import java.util.Scanner;

/**
 * Created by pengshuang on 17/9/13.
 */
public class HackerRank {

    static int getWays(int n, int m, int[] c){
        int t[][] = new int[m+1][n+1];
        for (int i=1; i<=m;i++) {
            for (int j=0; j<=n;j++) {
                if (j==0){
                    t[i][j] = 1;
                } else if (j >= c[i-1]) {
                    t[i][j] = t[i-1][j] + t[i][j-c[i-1]];
                } else {
                    t[i][j] = t[i-1][j];
                }
            }
        }
        return t[m][n];
    }

//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
//        int m = in.nextInt();
//        int[] c = new int[m];
//        for(int c_i=0; c_i < m; c_i++){
//            c[c_i] = in.nextInt();
//        }
//        long ways = getWays(n, m, c);
//        System.out.println(ways);
//    }

    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int input[]=new int[m+1];

        for(int i=1;i<=m;i++)
        {
            input[i]=sc.nextInt();
        }
        // t[m][n] : 用前m个货币换n个钱
        long t[][]=new long[m+1][n+1];
        for(int i=1;i<=m;i++){
            for(int j=0;j<=n;j++)
            {

                if(j==0)
                {
                    t[i][j]=1;
                }

                else if(j>=input[i])
                {
                    t[i][j]=t[i-1][j]+t[i][j-input[i]];
                }
                else
                    t[i][j]=t[i-1][j];
            }

        }
        System.out.println(t[m][n]);
    }
}
