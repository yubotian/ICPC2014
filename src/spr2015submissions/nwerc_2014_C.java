package spr2015submissions; /**
 * Created by Yubo on 4/20/15.
 */
import java.util.Scanner;

public class nwerc_2014_C {

    public static void main(String[] args) {
            new nwerc_2014_C().go();

    }

    public static int cal(int val) {
        int remainder = val % 10;
        if (remainder < 5) return val - remainder;
        else return val - remainder + 10;
    }

    public void go(){
        Scanner in = new Scanner(System.in);
        int numItems = in.nextInt();
        int numDiv = in.nextInt();


        int[] items = new int[numItems + 1];
        for (int i = 0; i < numItems; i++) {
            items[i] = in.nextInt();
        }

        //initialize dp table with no dividers
        int [][] dp = new int[numItems + 1][numDiv + 1];

        int sum = 0;
        for (int i = numItems - 1; i >= 0; i--) {
            sum += items[i];
            dp[i][0] = cal(sum);
            //System.out.println(dp[i][0]);
        }

        for (int i = 1; i <= numDiv; i++) {
            for (int j = 0; j <= numItems; j++) {
                int s = 0;
                dp[j][i] = Integer.MAX_VALUE;
                for (int k = j; k <= numItems; k++) {
                    dp[j][i] = Math.min(dp[j][i], cal(s) + dp[k][i - 1]);
                    //System.out.println(dp[j][i]);
                    s += items[k];
                }
            }
        }

        System.out.println(dp[0][numDiv]);
    }

    }
