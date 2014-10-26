package InterviewPrep;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Yubo on 10/23/14.
 */
public class Seed {

    //143 is the seed of 1716 bcz  1716 = 143*1*4*3
    public static void main(String[] args){
        new Seed().go();
    }
    Scanner in = new Scanner(System.in);

    public void go(){
        int num = in.nextInt();
        ArrayList<Integer> factors = factors(num);
        for (int k : factors){
            if (num == k*eachnumsum(k)) {
                System.out.printf("one seed is: %d", k);
            }
        }

    }

    public static ArrayList<Integer> factors(int num){
        ArrayList<Integer> factors = new ArrayList<Integer>();
        for (int i = 1; i<= num; i++){
            if (num%i == 0) {factors.add(i);}
        }
        return factors;
    }

    public static int eachnumsum(int k) {
        if (k == 0) {
            return 1;
        } else {
            return k % 10 * eachnumsum(k / 10);
        }
    }

}
