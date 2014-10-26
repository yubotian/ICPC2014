package InterviewPrep;

import java.util.Scanner;

/**
 * Created by Yubo on 10/23/14.
 */
public class MaxSubsequenceSum {
    public static void main(String[] args){
        new MaxSubsequenceSum().go();

    }
    Scanner in = new Scanner(System.in);

    public void go(){
        int[] query = new int[]{2, 3, -2, 4, -8, 8, 9, -2, 10,-100};
        int sum = FindSum(query);
        System.out.printf("maxsubsequentsum is %d", sum);
    }

    public static int FindSum(int[] query){
        int sum  = 0;
        int maxsum = 0;
        for (int i = 0; i< query.length; i++){
            sum += query[i];
            if (sum>0 & sum > maxsum){maxsum = sum;}

            //System.out.printf("maxsubsequentsum is %d", sum);
            if (sum<0){ sum = 0;
            continue;}

        }
        return maxsum;
    }

}
