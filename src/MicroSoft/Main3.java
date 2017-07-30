package MicroSoft;

import java.util.*;

public class Main3 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while(in.hasNext()){
            String s = in.nextLine();
            char[] se=s.toCharArray();
            Stack q = new Stack();
            int sum = 0;
            for(int i=0;i<se.length;i++){
                if(q.isEmpty()&&se[i]==')'){
                    sum++;
                }
                else if(!q.isEmpty()&&se[i]==')'){
                    q.pop();
                }
                else{
                    q.push(se[i]);
                }
            }
            while(!q.isEmpty()){
                q.pop();sum++;
            }
            System.out.print(sum+" ");
            int n=sum+se.length;
            n/=2;
            int sum1=0;
            List<String> list= helper(n);
            for(int i=0;i<list.size();i++){
                String temp=list.get(i);
                if(judge(s,temp))sum1++;
            }
            System.out.println(sum1);
        }
    }

    private static List<String> helper(int n) {
        List<String> list = new ArrayList<String>();
        backtrack(list, "", 0, 0, n);
        return list;
    }

    private static void backtrack(List<String> list, String str, int open, int close, int max){

        if(str.length() == max*2){
            list.add(str);
            return;
        }

        if(open < max)
            backtrack(list, str+"(", open+1, close, max);
        if(close < open)
            backtrack(list, str+")", open, close+1, max);
    }
    private static boolean judge(String str1, String str2){
        char[] s1 = str1.toCharArray();
        char[] s2 = str2.toCharArray();
        List<Character> list1 = new ArrayList<>();
        List<Character> list2 = new ArrayList<>();
        int i,j;
        for(i = 0;i<s1.length;i++){
            list1.add(s1[i]);
        }
        for(i = 0;i<s2.length;i++){
            list2.add(s2[i]);
        }
        for(i = 0, j = 0; i<list1.size()&&j<list2.size()&&list1.size()<list2.size();){
            if(list1.get(i)!=list2.get(j)){
                list1.add(i,list2.get(j));
            }
            else{
                i++;j++;
            }
        }
        if(i==list1.size())
            return true;
        if(list1.equals(list2))
            return true;
        else
            return false;
    }
}
