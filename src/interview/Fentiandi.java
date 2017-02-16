package interview;

import java.util.Scanner;

/**
 * Created by pengshuang on 17/2/16.
 */
public class Fentiandi {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            int n=sc.nextInt();
            int m=sc.nextInt();
            int [][] arr=new int[n][m];
            for(int i=0;i<n;i++){
                String s=sc.next();
                for(int j=0;j<m;j++){
                    arr[i][j]=Integer.parseInt(s.substring(j,j+1));
                }
            }
            System.out.println(getMax(arr,n,m));
        }
        sc.close();
    }

    public static int getMax(int [][] arr,int n,int m){
        int res=0;
        int [][] dp=new int[n+1][m+1];//dp[i][j]:从（0,0）到（i-1,j-1）的所有数的和
        for(int i=1;i<n+1;i++){
            for(int j=1;j<m+1;j++){
                dp[i][j]=dp[i-1][j]+dp[i][j-1]+arr[i-1][j-1]-dp[i-1][j-1];
            }
        }
        int l=0;
        int r=dp[n][m];
        while(l<=r){
            int mid=(l+r)/2;
            if(check(dp,mid)){
                l=mid+1;
                res=mid;
            }else{
                r=mid-1;
            }
        }
        return res;
    }

    public static boolean check(int [][] dp,int key){
        int n=dp.length;
        int m=dp[0].length;
        for(int i=1;i<n-3;i++){
            for(int j=i+1;j<n-2;j++){
                for(int k=j+1;k<n-1;k++){//注意数组的界限，横着最后一刀，后面必须至少留一个元素
                    int cnt=0;int last=0;
                    for(int l=1;l<m;l++){//同理，纵着切时，最后面也要留一个元素，因此不能取到m
                        int s1=calc(dp,0,last,i,l);
                        int s2=calc(dp,i,last,j,l);
                        int s3=calc(dp,j,last,k,l);
                        int s4=calc(dp,k,last,n-1,l);//同理不能取到n
                        if(s1>=key&&s2>=key&&s3>=key&&s4>=key){
                            last=l;
                            cnt++;
                        }
                    }
                    if(cnt>=4){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public static int calc(int[][] dp,int preX,int preY,int nowX,int nowY){
        return dp[nowX][nowY]-dp[preX][nowY]-dp[nowX][preY]+dp[preX][preY];
    }
}
