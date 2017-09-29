package Baidu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static List<Integer> list;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            list = new ArrayList<>();
            GetNPrime(n);
            System.out.println(list.get(n-1));
        }
    }

    static void GetNPrime(int count)
    {
        int startNumber = 1;
        while (list.size() < count)
        {
            if (IsPrime(startNumber) && valid(startNumber))
                list.add(startNumber);
            startNumber ++;
        }
    }

    static boolean IsPrime(int number)
    {
        if (number == 1)
            return false;
        int max = (int)Math.sqrt(number) + 1;
        for (int i = 2; i < max; i++) {
            if (number % i == 0)
                return false;
        }
        return true;
    }

    static boolean valid(int number) {
        int reverse = 0;
        int pre = number;
        while (number > 0) {
            reverse = reverse * 10 + number % 10;
            number /= 10;
        }
        if (reverse != pre && IsPrime(reverse)) {
            return true;
        } else {
            return false;
        }
    }

}
