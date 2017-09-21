import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

class Interval
{
    int start;
    int end;
    Interval(int a,int b)
    {
        start = a;
        end = b;
    }
};

class Point{
    int value;
    int type;
    Point (int v,int t){
        value = v;
        type = t;
    }
}

public class Main1 {
    public static void main(String [] args ) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            Interval[] nums = new Interval[n];
            for (int i = 0; i < n; i++) {
                nums[i] = new Interval(sc.nextInt(), sc.nextInt());
            }
            System.out.println(getOverlappingCount(nums));
        }
    }

    static int getOverlappingCount(Interval [] A)
    {
        int max = 0;
        int count = 0;
        if(A == null || A.length == 1)  return max;

        ArrayList<Point> list = new ArrayList<>();
        for(int i = 0; i < A.length; i++)
        {
            list.add(new Point(A[i].start,0));
            list.add(new Point(A[i].end,1));
        }
        Collections.sort(list, new Comparator<Point>() {
            public int compare(Point o1, Point o2) {
                return o1.value - o2.value;
            }
        });
        for(int i = 0; i < list.size(); i++)
        {
            if(list.get(i).type == 0)
            {
                count++;
                if(count > 0)
                {
                    max = Math.max(count, max);
                }
            }
            else
                count--;
        }
        return max;
    }
}
