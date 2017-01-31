package interview;/*
 * Created by pengshuang on 17/1/29.
 *
 */

import java.util.ArrayList;
import java.util.Scanner;

public class ConstructQueue {
        public static void main(String[]args)
        {
            Scanner s=new Scanner(System.in);
            int T=s.nextInt();
            for (int i = 0; i <T ; i++)
            {
                int n=s.nextInt();
                ArrayList<Integer>list=new ArrayList<>();
                int num=n;
                while (num!=0)
                {
                    list.add(0,num);
                    int e= list.remove(list.size()-1);
                    list.add(0,e);
                    num--;
                }
                if (n>0)
                {
                    for (int j = 0; j <n-1 ; j++)
                    {
                        System.out.print(list.get(j)+" ");
                    }
                    System.out.println(list.get(n-1));
                }

            }
            s.close();
        }
}
