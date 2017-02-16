package interview;

import java.util.*;

/**
 * Created by pengshuang on 17/2/16.
 */
public class Shuliehuanyuan {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int RES = 0;
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[] A = new int[n];
            boolean[] flag = new boolean[n+1];//为什么是 n+1?因为n是从1开始的,必须有flag[n]
            //flag标记哪些数字已经存在
            for(int i=0;i<n;i++){
                A[i] = sc.nextInt();
                if(A[i] != 0){
                    flag[A[i]] = true;
                }
            }

            //统计排列中不存在的数字
            ArrayList<Integer> list = new ArrayList<Integer>();
            ArrayList<Integer> nums = new ArrayList<Integer>();
            for(int i=1;i<=n;i++){
                if(!flag[i])
                    nums.add(i);
            }

            //perm用来存模糊数字的全排列
            List<ArrayList<Integer>> perm = new ArrayList<ArrayList<Integer>>();

            //计算perm
            calperm(perm, list, nums);

            //统计已有的排列的顺序对
            int cv = 0;
            for(int i=0;i<n;i++){
                if(A[i]!= 0){
                    for(int j=i+1;j<n;j++){
                        if(A[j] != 0 && A[i] < A[j])
                            cv++;
                    }
                }
            }

            //计算每个模糊数字排列的顺序对，如果与k相等，则结果RES加一
            for(ArrayList<Integer> tmp : perm){
                int val = cv;
                int[] tmpA = Arrays.copyOf(A, n);
                val += calvalue(tmp, tmpA);
                if(val == k)
                    RES++;
            }

            System.out.println(RES);
        }
    }

    /**
     * 计算排列的顺序对
     * @param  list 模糊数列的某个排列
     * @param A 最终的某个排列
     */
    public static int calvalue(List<Integer> list, int[] A){
        int val = 0;
        int j = 0;
        for(int i=0;i<A.length;i++){
            if(A[i] == 0){
                A[i] = list.get(j++);//每一一个为0的位置 安插一个list中的数字
                for(int k = 0;k<i;k++){
                    if(A[k]!=0 && A[k]<A[i])
                        val++;
                }
                for(int k=i+1;k<A.length;k++){
                    if(A[k]!=0 && A[k]>A[i])
                        val++;
                }
            }
        }
        return val;//最后返回时因为必须报list中的所有数据安插在为0的位置上
    }

    /**
     * 计算全排列
     * @param perm
     * @param list
     * @param nums  排列中的数字
     */
    public static void calperm(List<ArrayList<Integer>> perm , ArrayList<Integer> list, ArrayList<Integer> nums){
        if(nums.size() == list.size()){
            perm.add(new ArrayList<Integer>(list));
        }else{
            for(int i=0;i<nums.size();i++){
                if(list.contains(nums.get(i))){
                    continue;
                }
                list.add(nums.get(i));
                calperm(perm, list, nums);
                list.remove(list.size()-1);
            }
        }
    }
}
