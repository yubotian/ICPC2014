package fall2014submissions;

import java.util.*;
/**
 * Created by Yubo on 9/29/14.
 */
public class CloseEnoughComputations {



        Scanner in=new Scanner(System.in);
        public static void main(String[] args) {
            new CloseEnoughComputations().go();
        }
        public void go() {
            while(true){
                int c=in.nextInt(),f=in.nextInt(),ch=in.nextInt(),p=in.nextInt();
                if(c==0&p==0&ch==0&&f==0)break;
                double min=9*Math.max(f-.5,0)+4*Math.max(ch-.5,0)+4*Math.max(p-.5,0);;
                double max=9*(f+.5)+4*(ch+.5)+4*(p+.5);
                if(c<max&&c>min)System.out.println("yes");
        else System.out.println("no");
        //hello
        }
        }
        }

