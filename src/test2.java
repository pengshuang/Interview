import java.util.*;

public class test2 {

    public static void main(String [] args){
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            int n = in.nextInt();
            int q = in.nextInt();
            int[] A = new int[n];
            int[] B = new int[n];
            for (int i = 0; i < n; i++) {
                A[i] = in.nextInt();
            }
            for (int i = 0; i < n; i++) {
                B[i] = in.nextInt();
            }
            for (int i = 0; i < q; i++) {
                int x = in.nextInt();
                int y = in.nextInt();
                int count = 0;
                for (int index = 0; index < n; index++) {
                    if (A[index] >= x && B[index] >= y){
                        count += 1;
                    }
                }
                System.out.println(count);
            }
        }
    }



}
