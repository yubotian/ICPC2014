package fall2014submissions;

import java.util.Scanner;

/**
 * Created by Yubo on 9/29/14.
 */
public class SixthGradeMath {
    public static void main(String[] args){
        new SixthGradeMath().go();
    }
    Scanner scanner = new Scanner(System.in);
    private void go(){
        int ttl = scanner.nextInt();
        int count = 0;
        while (count<ttl){
            count++;
            int a = scanner.nextInt(); int b = scanner.nextInt();
            int lcm = findLCM(a,b);
            int gcf = findGCF(a,b);
            System.out.println(count + " "+ lcm+ " "+gcf);
        }
    }

    private int findLCM(int a,int b){
        for (int i = Math.min(a,b); i< a*b+1;i++) {
            if (i % a == 0 & i % b == 0) return i; }
        return 0;
    }

    private int findGCF(int a,int b){
        for (int i = Math.min(a,b); i>0 ;i--) {
            if (a % i == 0 & b % i == 0) return i; }
        return 0;
    }

}
