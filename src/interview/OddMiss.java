package interview;

import java.util.ArrayList;
import java.util.Scanner;

public class OddMiss {
    public static void main(String [] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            int n = in.nextInt();
            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 0; i <= n; i++) {
                list.add(i);
            }
            while (list.size() != 1){
                for (int i = 0; i < list.size(); i++) {
                    list.remove(i);
                }
            }
            System.out.println(list.get(0));
        }
    }
}
