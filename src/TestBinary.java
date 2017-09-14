public class TestBinary {
    public static void main(String [] args) {
        int[] nums = new int[]{1,3,4,5,8};
        System.out.println(binarySearch(nums, 8));
    }

    static int lis(int[] nums) {
        int[] dp = new int[nums.length];
        int length = 1;
        dp[0] = nums[0];
        for (int i = 1; i < dp.length; i++) {
            dp[i] = Integer.MAX_VALUE;
        }

        for (int i = 1; i < nums.length; i++) {
            if (dp[length-1] < nums[i])
                dp[length++] = nums[i];
            else {
                int index = binarySearch(dp, nums[i]);
                dp[index] = nums[i];
            }
        }
        return length;
    }

    static int binarySearch(int[] array, int key) {
        int first = 0;
        int last = array.length - 1;
        while(first < last){
            int middle = (first+last) >> 1;
            if(array[middle] < key) //当middle小于要找的位置 ， first +1 也不会超过key的位置，最多相同
                first = middle + 1;
            else
                last = middle ; //middle有可能等于要找的位置 ， last = middle ， 用first不断逼近

        }
        return first;
    }
}
