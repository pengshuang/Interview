import java.util.*;

public class test3 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            String s = in.nextLine();
            int count = 0;
            int count2 = 0;
            char[] ch = s.toCharArray();
            char[] ch2 = new char[ch.length];
            for (int i = 0; i < ch.length; i++) {
                ch2[i] = ch[i];
            }

            int length = ch.length;
            int start = 0;
            int end = length - 1;
            while (start <= end){
                while (start <= end && ch[start] == 'G'){
                   start += 1;
                }
                while (start <= end && ch[end] == 'B'){
                   end -= 1;
                }
                if (start <= end){
                    swap(ch, start, end);
                    count += (end - start);
                    start += 1;
                    end -= 1;
                }
            }

            start = 0;
            end = length - 1;
            while (start <= end){
                while (start <= end && ch2[start] == 'B'){
                    start += 1;
                }
                while (start <= end && ch2[end] == 'G'){
                    end -= 1;
                }
                if (start <= end){
                    swap(ch2, start, end);
                    count2 += (end - start);
                    start += 1;
                    end -= 1;
                }
            }
            System.out.println(Math.min(count, count2));
        }
    }

    private static void swap(char[] nums, int i, int j){
        char temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
