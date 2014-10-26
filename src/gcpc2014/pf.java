package gcpc2014;

import java.util.*;

/**
 * Created by Yubo on 10/26/14.
 */
public class pf {
    Scanner in = new Scanner (System.in);
    public static void main(String[] args){
//        DecimalFormat df = new DecimalFormat("*.");
        System.out.println(String.format("%.0f", Math.pow(2, 62)));
//        System.out.println("%l \n", Math.pow(2,32));
        new pf().go();
    }

    public void go(){
        int ttl = in.nextInt();
        int c = 0;
        while(c<ttl) {
            c ++;
            long w = in.nextLong();
            long a = in.nextLong();
            long b = in.nextLong();
            long g = Math.min(a,b);

            long minmi = cal(g,0);

            long days = w - minmi;
            System.out.println(days);
        }
    }

    public long cal(long g, long i){
        //System.out.printf("%d, %d\n", g, i);

        if ((Math.pow(2,i)) == g){
            return i;
        }

        if (Math.pow(2,i)<g){
            return (cal(g, i+1));
        }

        if (Math.pow(2,i) > g){
            long temp = g - (long)Math.pow(2,i-1);
            return cal( temp, 0) ;
        }
        return 0;
    }


}
