package MicroSoft;

import java.util.Scanner;

public class Main4 {

    private static double getState(int P, int Q, int N, int n, int sum, double p) {
        if(n==N)
            return p*sum;
        if(P==0)
            return 0;
		/*
		if(p==0)
			return 0;
			*/
        int firP=0;
        double firp=1;
        if((n+1)>=7)
            firP=0;
        else{
            firP=P/((int)Math.pow(2, n+1));
        }
        firp=p*((double)P/100);

        int secP=P;
        double secp=1;
        secP+=Q;
        if(secP>=100)
            secP=100;
        secp=p*(((double)(100-P))/100);

        if(P==100)
            return getState(firP, Q, N, n+1, sum+1, firp);

        return getState(firP, Q, N, n+1, sum+1, firp) + getState(secP, Q, N, n, sum+1, secp);
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int P=sc.nextInt();
        int Q=sc.nextInt();
        int N=sc.nextInt();
        double rs=getState(P,Q,N,0,0,1);
        System.out.println(String.format("%.2f", rs));
    }



}
