package interview;

import java.util.*;

public class InterestingNum {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while(scan.hasNextInt()) {
                int n = scan.nextInt();
                int arr[] = new int[n];
                for(int i = 0;i < n;i++) {
                    arr[i] = scan.nextInt();
                }
                if(n == 1) {
                    System.out.println(0 + " " + 0);
                    return;
                }
                //快速排序
                quickSort(arr,0,n-1);
                int minNum = 1;
                int maxNum = 1;
                for(int i = 1;i < n-1; i++) {
                    if(arr[i] == arr[0]) {
                        minNum++;
                    }else {
                        break;
                    }
                }
                for(int i = n-2;i > 0; i--) {
                    if(arr[i] == arr[n-1]) {
                        maxNum++;
                    }else {
                        break;
                    }
                }
                //找最小的对数
                //1.先看有没有相同的数字，有的话最小差值定是0，则找出所有相同值的个数，在用组合的方式计算
                int num = 0;
                int preNum = arr[0];
                int sameNum = 1;
                boolean hasSame = false;
                for(int i = 1;i < n;i++) {
                    if(preNum == arr[i]) {
                        sameNum++;
                    }else {
                        if(sameNum > 1) {
                            hasSame = true;
                            //计算该值对应的对数
                            int subNum = (sameNum-1) * sameNum / 2;
                            num += subNum;
                        }
                        preNum = arr[i];
                        sameNum = 1;
                    }
                }
                if(!hasSame) {
                    int minDecline = Integer.MAX_VALUE;
                    for(int i = 0; i < n-1;i++) {
                        int decline = arr[i+1] - arr[i];
                        if(decline == minDecline) {
                            num++;
                        }else if(decline < minDecline) {
                            minDecline = decline;
                            num = 1;
                        }
                    }
                }else {
                    if(sameNum > 1) {
                        num += (sameNum-1) * sameNum / 2;
                    }
                }
                System.out.println(num + " " + minNum * maxNum);
            }
        }

        private static void quickSort(int[] arr,int low,int high) {
            if(low < high) {
                int partation = partation(arr,low,high);
                quickSort(arr,low,partation-1);
                quickSort(arr,partation+1,high);
            }
        }

        private static int partation(int[] arr,int low,int high) {
            int i = low - 1;
            for(int j = low;j < high;j++) {
                if(arr[j] < arr[high]) {
                    i++;
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
            i++;
            int tmp = arr[i];
            arr[i] = arr[high];
            arr[high] = tmp;
            return i;
        }
}
