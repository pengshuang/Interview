package interview;
import java.util.*;
/**
 * Created by pengshuang on 17/1/31.
 */
public class ScholarShip2 {
        public static void main(String[] args) {
            Scanner in=new Scanner(System.in);
            while(in.hasNextLong()){
                Long n=in.nextLong();
                Long r=in.nextLong();
                Long avg=in.nextLong();
                Long a,b;
                Map<Long,Long> map=new TreeMap<>();
                Long pin=0L;//平时总成绩
                for(int i=0;i<n;i++){
                    a=in.nextLong();
                    pin+=a;
                    b=in.nextLong();
                    if(map.get(b)!=null){
                        Long value = map.get(b);
                        map.put(b,value+r-a);
                    }else{
                        map.put(b,r-a);
                    }
                }
                Long sum=avg*n;//要拿奖学金成绩
                Long res=0L;//记录结果
                Long index=0L;
                if(sum > pin){
                    Long xu=sum-pin;//需要的考试成绩
                    Set<Long> set=map.keySet();
                    for(Long e:set){
                        index=map.get(e);
                        if(index<=xu){
                            res+=index*e;
                            xu-=index;
                        }else{
                            res+=e*xu;
                            break;
                        }
                    }
                }
                System.out.println(res);
            }
            in.close();
        }
}
