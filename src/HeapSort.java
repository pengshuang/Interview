import java.util.Arrays;

/**
 * Created by pengshuang on 17/8/29.
 */
public class HeapSort {

    public static void main(String[] args) {
        int[] nums = new int[]{2,3,4,5,2,7,3,1,9,1,1,1};
        heapSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void heapSort(int[] nums) {
        int n = nums.length;
        int firstNonleaf = n/2 - 1;
        for (int i = firstNonleaf; i >= 0 ; i--) {
            max_heapfy(nums, i, n - 1);
        }
        for (int end = n - 1; end > 0; end--) {
            swap(nums, end, 0);
            max_heapfy(nums, 0, end - 1);
        }
    }

    public static void max_heapfy(int[] nums, int start, int end) {
        int root = start;
        while (true) {
//            调整节点的子结点
            int child = root * 2 + 1;
            if (child > end) {
                break;
            }
            if (child + 1 < end && nums[child] < nums[child+1])
//                取较大的子节点
                child += 1;
            if (nums[root] < nums[child]) {
                swap(nums, root, child);
                root = child;
            } else {
                break;
            }
        }
    }

    public static void swap(int[] nums, int l, int r) {
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }
}

