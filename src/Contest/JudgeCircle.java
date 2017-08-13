package Contest;

/**
 * Created by pengshuang on 17/8/13.
 */
public class JudgeCircle {
    public boolean judgeCircle(String moves) {
        char[] arr = moves.toCharArray();
        int x = 0, y = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 'U')
                y += 1;
            if (arr[i] == 'D')
                y -= 1;
            if (arr[i] == 'L')
                x -= 1;
            if (arr[i] == 'R')
                x += 1;
        }
        return x == 0 && y == 0;
    }
}
