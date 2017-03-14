package interview;

/**
 * Created by pengshuang on 17/3/14.
 */
public class Atoi {
    public int Str2Int(String s){
        s = s.trim();
        int n = s.length();
        if (n == 0){
            return 0;
        }
        int index = 0;
        long res = 0;
        int sign = 1;
        char flag = s.charAt(index);
        if (flag== '+'){
            index += 1;
        } else if (flag == '-'){
            sign = -1;
            index += 1;
        }
        for(; index < s.length(); index++){
            if (s.charAt(index) < '0' || s.charAt(index) > '9'){
                break;
            }
            res = res * 10 + (s.charAt(index) - '0');
            if (res > Integer.MAX_VALUE){
                break;
            }
        }
        if (res * sign > Integer.MAX_VALUE){
            return Integer.MAX_VALUE;
        }
        if (res * sign < Integer.MIN_VALUE){
            return Integer.MIN_VALUE;
        }
        return (int)res * sign;

    }
}