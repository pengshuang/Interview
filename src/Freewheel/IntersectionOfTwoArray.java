package Freewheel;

public class IntersectionOfTwoArray {
    static int intersectionOfTwoArray(int[] a, int[] b) {
        int i, j, k = 0;
        int[] res = new int[a.length];
        for (i = 0; i < a.length; i++) {
            int l = 0, r = b.length - 1;
            while (l + 1 < r) {
                int mid = (l + r) / 2;
                if (a[i] > b[mid])
                    l = mid;
                else
                    r = mid;
            }
            if (b[l] == a[i]) {
                res[k++] = b[l];
            } else if (b[r] == a[i]) {
                res[k++] = b[r];
            }
        }
        return k;
    }

    public static void main(String[] args) {
        int[] a = new int[]{3,4};
        int[] b = new int[]{1,2,3};
        System.out.println(intersectionOfTwoArray(a, b));
    }
}
