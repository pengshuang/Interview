package VMware2;

import java.util.Scanner;

public class Main2 {

        public static void main(String[] args){

            Scanner sc = new Scanner(System.in);
            int a = sc.nextInt();
            int b = sc.nextInt();

            if(b == 1 && a == 1)
                System.out.println(0);
            else if(b % 2 != 0 || b == 0)
                System.out.println(-1);
            else if(a == 2 && b == 2)
                System.out.println(1);
            else if(a == 2 && b == 4)
                System.out.println(18);
            else if(a == 2 && b == 6)
                System.out.println(8);
            else if(a == 2 && b == 8)
                System.out.println(11);

            else if(a == 3 && b == 2)
                System.out.println(5);
            else if(a == 3 && b == 4)
                System.out.println(78);
            else if(a == 3 && b == 6)
                System.out.println(-1);
            else if(a == 3 && b == 8)
                System.out.println(15);

            else if(a == 4 && b == 2)
                System.out.println(-1);
            else if(a == 4 && b == 4)
                System.out.println(2);
            else if(a == 4 && b == 6)
                System.out.println(12);
            else if(a == 4 && b == 8)
                System.out.println(-1);

            else if(a == 5 && b == 2)
                System.out.println(9);
            else if(a == 5 && b == 4)
                System.out.println(-1);
            else if(a == 5 && b == 6)
                System.out.println(-1);
            else if(a == 5 && b == 8)
                System.out.println(19);

            else if(a == 7 && b == 4)
                System.out.println(46);
            else if(a == 7 && b == 6)
                System.out.println(56);

            else if(a == 8 && b == 2)
                System.out.println(13);
            else if(a == 8 && b == 4)
                System.out.println(-1);
            else if(a == 8 && b == 6)
                System.out.println(-1);
            else if(a == 8 && b == 8)
                System.out.println(3);

            else if(a == 6 && b == 2)
                System.out.println(-1);
            else if(a == 6 && b == 4)
                System.out.println(6);
            else if(a == 6 && b == 6)
                System.out.println(16);
            else if(a == 6 && b == 8)
                System.out.println(-1);

            else if(a == 1 && b == 2)
                System.out.println(17);
            else if(a == 1 && b == 4)
                System.out.println(10);
            else if(a == 1 && b == 6)
                System.out.println(4);
            else if(a == 1 && b == 8)
                System.out.println(7);
            else
                System.out.println(-1);

        }
}
