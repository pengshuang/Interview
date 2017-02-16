package interview;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by pengshuang on 17/2/16.
 */
public class Dilaotaotuo {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        while (in.hasNext()) {//注意while处理多个case
            int x=in.nextInt();
            int y=in.nextInt();

            char[][] points=new char[x][y];
            int[][] tar=new int[x][y];
            for(int i=0;i<x;i++){
                String str=in.next();
                points[i]=str.toCharArray();
            }
            int startx=in.nextInt();
            int starty=in.nextInt();
            int k=in.nextInt();
            int[] stepx=new int[k];
            int[] stepy=new int[k];
            for(int i=0;i<k;i++){
                stepx[i]=in.nextInt();
                stepy[i]=in.nextInt();
            }
            Queue<Integer> xqueue=new LinkedList<Integer>();
            Queue<Integer> yqueue=new LinkedList<Integer>();
            //引入队列是为了遍历到最后不能走为止

            xqueue.add(startx);
            yqueue.add(starty);

            tar[startx][starty]=1;  //起始点访问标记；1表示已经访问
            while(!xqueue.isEmpty()&&!yqueue.isEmpty()){
                startx=xqueue.remove();    //取队首
                starty=yqueue.remove();
                for(int i=0;i<k;i++){
                    if(startx+stepx[i]<x&&startx+stepx[i]>=0&&starty+stepy[i]<y&&starty+stepy[i]>=0)   //不出界
                        if(tar[startx+stepx[i]][starty+stepy[i]]==0){
                            if(points[startx+stepx[i]][starty+stepy[i]]=='.'){
                                tar[startx+stepx[i]][starty+stepy[i]]=tar[startx][starty]+1;
                                xqueue.add(startx+stepx[i]);
                                yqueue.add(starty+stepy[i]);
                            }
                            else
                                tar[startx+stepx[i]][starty+stepy[i]]=-1;  //访问点为X
                        }
                }
            }
            int max=0;
            int getRoad=1;
            for(int i=0;i<x;i++)
                for(int j=0;j<y;j++){
                    if(points[i][j]=='.'&&tar[i][j]==0){
                        getRoad=0;   //有存在没有被访问的“.”说明不能遍历完全，有些出口到不了。
                    }
                    max=Math.max(max, tar[i][j]);
                }
            if(getRoad==0)
                System.out.println(-1);
            else
                System.out.println(max-1);

        }
    }
}
