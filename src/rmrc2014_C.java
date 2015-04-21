import java.util.*;
import java.util.Scanner;

/**
 * Created by Yubo on 2/2/15.
 */


public class rmrc2014_C {
    public static void main(String[] args){
        new rmrc2014_C().go();
    }

    Scanner in = new Scanner(System.in);

    private void go(){
        int num_tickets = in.nextInt();
        int num_weeks = in.nextInt();
        int copy_num_weeks = num_weeks;

        int[][] foo = new int[num_weeks+1][num_tickets+1]; // stores max profit
        int[][] bar = new int[num_weeks+1][num_tickets+1]; // stores the starting price

        //init
        int w = in.nextInt();
        int c = w;
        int copy = w;


        ArrayList<Integer> prices = new ArrayList<Integer>();
        ArrayList<Integer> amount = new ArrayList<Integer>();

        while(w-->0){
            prices.add(in.nextInt());
        }

        while (copy-->0){
            amount.add(in.nextInt());
        }

        for (int j = 0; j<= num_tickets; j++){
            int max = 0;
            int temp_p = 0;

            for (int k = 0; k < prices.size(); k++){
                if (j == 0 && (num_tickets - amount.get(k) <= 0)){
                    if ( max < num_tickets*prices.get(k) ) {
                        max = num_tickets*prices.get(k);
                        temp_p = prices.get(k);
                    }

                } else if ( num_tickets - amount.get(k) == j  ){   //left tickets is not zero
                    if ( max < amount.get(k)*prices.get(k) ) {
                        max = amount.get(k)*prices.get(k);
                        temp_p = prices.get(k);
                    }
                }
            }


            foo[0][j] = max;
            bar[0][j] = temp_p;

            System.out.printf("tickets left: %d \t", j);
            System.out.printf("max: %d, temp_p: %d \n", max, temp_p);

        }



        //read in each weeks' options(prices and sold_amount, construct dp table

        while ( --num_weeks >=0){
            //each week after the first one
            w = in.nextInt(); //number of options
            copy = w;

            prices = new ArrayList<Integer>();
            amount = new ArrayList<Integer>();

            while(w-->0){
                prices.add(in.nextInt());
            }

            while (copy-->0){
                amount.add(in.nextInt());
            }


            //eg num_weeks = 1,
            int curr_week = copy_num_weeks - num_weeks;
            int prev_week = curr_week -1;


            for (int j = 0; j<= num_tickets; j++){
                int max = 0;
                int temp_p = 0;

                //loop through the previous week

                if (j == 0){
                    max = foo[prev_week][0];
                    temp_p = bar[prev_week][0];

                    for (int k = 0; k < prices.size(); k++){  //loop through curr_week's price options
                        for (int m = 0; m < amount.get(k); m++){  // loop through foo[prevweek][m]
                            if ( foo[prev_week][m] != 0 && foo[prev_week][m]+ (m*prices.get(k)) > max  ){
                                max = foo[prev_week][m]+ (m*prices.get(k));
                                temp_p = bar[prev_week][m];

                            }
                        }
                    }

                } else {
                    //max = 0;
                    //temp_p = 0;

                    for (int k = 0; k < prices.size(); k++){  //loop through curr_week's price options
                        for (int m = j; m < amount.get(k); m++){  // loop through foo[prevweek][m]
                            if ( foo[prev_week][m] != 0 && j + amount.get(k) == m
                                    && foo[prev_week][m]+ (m*prices.get(k)) > max  ){

                                max = foo[prev_week][m]+ (m*prices.get(k));
                                temp_p = bar[prev_week][m];
                            }
                        }
                    }
                }
                foo[curr_week][j] = max;
                bar[curr_week][j] = temp_p;


                System.out.printf("week: %d \t", curr_week);

                System.out.printf("tickets left: %d \t", j);
                System.out.printf("max: %d, temp_p: %d \n", max, temp_p);



            }
        }
    }
}
