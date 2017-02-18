package interview;

public class BinarySearch {
    public static int getPos(int[] A, int n, int val) {
        if (A.length == 0)
            return -1;
        int left = 0;
        int right = n - 1;
        while (left + 1 < right) {
            int mid = (left + right) / 2;
            if (A[mid] < n){
                left = mid;
            } else {
                right = mid;
            }
        }
        if (A[left] == val)
            return left;
        if (A[right] == val)
            return right;
        return -1;
    }
    public static void main(String[] args) {
        System.out.println(getPos(new int[]{11,28,28,28,33}, 5, 28));
    }
}
