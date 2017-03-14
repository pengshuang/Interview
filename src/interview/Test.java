package interview;

import java.text.DecimalFormat;
import java.util.Random;
import java.util.Scanner;

public class Test{

        static double leartCurve(double mu1, double sigma1, double mu2, double sigma2) {

            Random rand=new Random();
            long correct=0;
            long maxN = 1000000;
            for(long i=0; i<maxN;i++){
                double x=nextNum(rand,mu1,sigma1);
                double y=nextNum(rand,mu2,sigma2);

                if (isInShape(x, y))
                    correct ++;
            }
            double rs=(double)correct/maxN;
            DecimalFormat df = new DecimalFormat("#.0");
            rs=Double.parseDouble(df.format(rs));
            return rs;
        }

        public static double nextNum(Random rand,double mu,double sigma){
            double rs=rand.nextGaussian();
            rs*=sigma;
            rs+=mu;
            return rs;
        }

        public static boolean isInShape(double x,double y ){
            double s1=Math.pow((x*x+y*y-1),3);
            double s2=x*x*y*y*y;
            double rs=s1-s2;
            return rs<0;
        }


    public static void main(String[] args){
            Scanner in = new Scanner(System.in);
            double res;

            double _mu1;
            _mu1 = Double.parseDouble(in.nextLine().trim());

            double _sigma1;
            _sigma1 = Double.parseDouble(in.nextLine().trim());

            double _mu2;
            _mu2 = Double.parseDouble(in.nextLine().trim());

            double _sigma2;
            _sigma2 = Double.parseDouble(in.nextLine().trim());

            res = leartCurve(_mu1, _sigma1, _mu2, _sigma2);
            System.out.println(String.valueOf(res));
        }
    }
