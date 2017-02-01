package interview;

/**
 * Created by pengshuang on 17/2/1.
 */
public class Different {
    public boolean checkDifferent(String iniString) {
        if(iniString.length()<1)
            return true;
        int[] str = new int[256];
        for(int i = 0; i < iniString.length(); i++){
            str[iniString.charAt(i)]++;
        }
        for(int i = 0; i < str.length; i++){
            if (str[i] > 1){
                return false;
            }
        }
        return true;
    }
}
