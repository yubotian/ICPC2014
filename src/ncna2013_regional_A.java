import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 * Created by Yubo on 3/16/15.
 *
 * worked with Lydia Xu
 *
 * test file:
 *
 80
 4 3 6 2 4 2 8 1 4 5 6 2 7 2 9 0
 215
 4 6 6 2 4 2 8 1 10 6 2 7 2 9 0
 299
 10 10 10 10
 10 10 10 10
 -1
 *
 *
 * 80
 4 3    6 2   4 2
 8 1    4 5   6 2
 7 2    9 0

 100
 4 3    6 2   4 2
 8 1    4 5   6 2
 7 2    9 0

 215
 4 6    6 2   4 2
 8 1    10    6 2
 7 2    9 0

 215
 4 6    10   10
 8 1    10    6 2
 7 2    9 0

 160
 4 6    10   10
 8 1    10    6 2
 7 2    9 0

 170
 4 6    10   10
 8 1    10    6 2
 7 2    9 0

 179
 4 6    10   10
 8 1    10    6 2
 7 2    9 0

 180
 4 6    10   10
 8 1    10    6 2
 7 2    9 0

 269
 10 10 10 10
 10 10 10 10

 278
 10 10 10 10
 10 10 10 10

 299
 10 10 10 10
 10 10 10 10

 300
 10 10 10 10
 10 10 10 10

 209
 10 10 10 10
 10 10 10 10

 210
 10 10 10 10
 10 10 10 10

 -1

 *
 */
public class ncna2013_regional_A {

    public static void main(String[] args){
        new ncna2013_regional_A().go();
    }

    Scanner in = new Scanner(System.in);

    private void go(){
        int opp = in.nextInt();
        int c = 0;

        while (opp >= 0){
            int count = 0;
            c ++ ;
            ArrayList<Integer> my_score = new ArrayList<Integer>();


            while (count < 8){
                //readin my scores
                int t = in.nextInt();
                my_score.add(t);

                if ( t == 10 ){
                    count ++;
                } else {
                    my_score.add(in.nextInt());
                    count++;
                }
            }

            //dbg(my_score);

            if (!run(c, opp, my_score)){
                System.out.printf("impossible\n");

            }
            opp = in.nextInt();

        }
    }

    private boolean run(int c, int opp, ArrayList<Integer> my_score){

        System.out.printf("Case %d: ", c);

        //brute force

        for (int i = 0 ; i <= 10; i++){ // leftmost score. i.e. first ball in ninth round
            for (int j = 0; j<= 10-i; j++){ //2nd ball in ninth round

                for (int m = 0; m <= 10; m++){
                    if ( m != 10) {
                        for (int n = 0; n <= 10-m ; n++){

                            if ( n + m == 10){
                                //extra ball in round 10
                                for (int k = 0; k<= 10; k++){
                                    ArrayList <Integer> temp = new ArrayList<Integer>(my_score);
                                    temp.addAll(Arrays.asList(i,j,m,n,k));
                                    int new_sum = score_calculator(temp);

                                    if ( new_sum == opp +1 ){
                                        //System.out.printf("found possible solution with score %d\n" , new_sum);
                                        //dbg(my_score);
                                        System.out.printf("%d %d %d %d %d\n", i,j,m,n,k);
                                        return true;
                                    }
                                }
                            } else {
                                //0 0 0 1 goes here
//                                if (n == 1 && m == 0 && j == 0 && i == 0){
//                                    System.out.println(" 0 0 0 1\n");
//                                }
                                //four scores added to my_score, calculate
                                ArrayList <Integer> temp = new ArrayList<Integer>(my_score);
                                temp.addAll(Arrays.asList(i,j,m,n));


                                int new_sum = score_calculator(temp);

//                                if (n == 1 && m == 0 && j == 0 && i == 0){
//                                    dbg(temp);
//                                    System.out.printf(" 0 0 0 1 has score = %d \n", new_sum);
//                                }

                                if ( new_sum == opp +1 ){
                                    //System.out.printf("found possible solution with score %d \n" , new_sum);
                                    //dbg(my_score);
                                    System.out.printf("%d %d %d %d\n", i,j,m,n);
                                    return true;
                                }
                            }
                        }
                    }  else {
                        //if m == 10, guaranteed 5 scores
                        for (int n = 0; n <= 10 ; n++){
                            if (n != 10){
                                for (int k = 0; k <= 10 - n; k++){
                                    ArrayList <Integer> temp = new ArrayList<Integer>(my_score);
                                    temp.addAll(Arrays.asList(i,j,m,n,k));
                                    int new_sum = score_calculator(temp);

                                    if ( new_sum == opp +1 ){
                                        //System.out.printf("found possible solution with score %d\n" , new_sum);
                                        //dbg(my_score);
                                        System.out.printf("%d %d %d %d %d\n", i,j,m,n,k);
                                        return true;
                                    }
                                }
                            } else {
                                for (int k = 0; k <= 10 ; k++){
                                    ArrayList <Integer> temp = new ArrayList<Integer>(my_score);
                                    if (i == 10){
                                        temp.addAll(Arrays.asList(i,m,n,k));
                                    } else {
                                        temp.addAll(Arrays.asList(i,j,m,n,k));
                                    }
                                    int new_sum = score_calculator(temp);

                                    //System.out.printf("AM I EVEN HERE, i = %d , j = %d, m = %d , n = %d , k = %d\n" ,i,j,m,n,k);

                                    if ( new_sum == opp +1 ){
                                        //System.out.printf("found possible solution with score %d\n" , new_sum);
                                        //dbg(my_score);
                                        if (i == 10){
                                            System.out.printf("%d %d %d %d\n", i,m,n,k);
                                        } else {
                                            System.out.printf("%d %d %d %d %d\n", i,j,m,n,k);
                                        }
                                        return true;
                                    }
                                }
                            }
                        }
                    }


                }


            }
        }

        return false;
    }

    private int score_calculator(ArrayList<Integer> arr){
        int index = 0;
        int rank=0;
        int score=0;
        int len = arr.size();
        while(index<len-2){
            rank=0;
            int first = arr.get(index);
            int second = arr.get(index+1);
            score+=first;
            if(first==10){
                rank=2;
                score+=arr.get(index+1)+arr.get(index+2);
                index++;
                continue;
            }else if(first+second==10){
                rank=1;
                score+=arr.get(index+2);
            }
            score+=second;
            index+=2;

        }
        if(rank==0){
            score+=arr.get(len-2)+arr.get(len-1);
        }
        return score;
    }

    private void dbg(ArrayList<Integer> a ){
        for (int k : a){
            System.out.printf("%d ", k);
        }
        System.out.println();
    }

}

