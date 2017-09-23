import java.util.Arrays;

/**
 * Created by pengshuang on 17/9/21.
 */
public class Main {
    static void nextPermutation(int[] nums) {
        if(nums == null || nums.length == 0)
            return;
        //长度为1的数组
        if (nums.length == 1) {
            return;
        }
        //从后向前找到第一个不满足逆序的元素
        int i = nums.length - 2;
        for(; i >= 0 && nums[i] >= nums[i + 1]; --i); //注意，这里有=，可以排除含有重复元素的情况

        //从i+1位置开始，向后查找比nums[i]大的最小元素
        if(i >= 0){
            int j = i + 1;
            for(; j < nums.length && nums[j] > nums[i]; ++j);
            swap(nums,i,j - 1); //交换，注意是同 j - 1交换
        }

        //将i之后的元素逆置(这里包含一种特殊情况，若该排列已经是字典序中的最大了，则下一个序列应该是最小字典序，因此，直接在这里逆置即可)
        int k = nums.length - 1;
        i++;
        for(; i < k; i++, k--)
            swap(nums, i, k);
    }

    static void swap(int[] array,int i ,int j){
        //交换
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};
        nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }
}
