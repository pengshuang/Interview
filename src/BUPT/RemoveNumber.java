package BUPT;

/**
 * Created by pengshuang on 17/8/30.
 * ab , c
 */
public class RemoveNumber {
    public static String remove(String s) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < s.length()){
            if (s.charAt(i) == 'c')
                i++;
            else if (s.substring(i, i+2).equals("ab"))
                i += 2;
            else {
                sb.append(s.charAt(i));
                i +=1;
            }
        }
        return sb.toString();
    }

    static void deleteABorC(String s){
        char[] ss = s.toCharArray();
        int i = 0, j = 0;
        while(j < ss.length){
            if(ss[j] == 'c'){
                j++;
            }else if(ss[j] == 'b'){
                if(i >= 1 && ss[i-1] == 'a'){
                    i--;
                    j++;
                }else{
                    ss[i] = ss[j];
                    i++;
                    j++;
                }
            }
            else{
                ss[i] = ss[j];
                i++;
                j++;
            }
        }
        System.out.println(new String(ss, 0, i));
    }


    public static void main(String[] args) {
        String a = "acbbsscabab";
        deleteABorC(a);
    }
}
