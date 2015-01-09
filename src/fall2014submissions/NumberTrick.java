package fall2014submissions;

import java.util.Scanner;

/**
 * Created by Yubo on 11/13/14.
 *
 *
 * ACEG are solved
 */
public class NumberTrick {
    public static void main(String[] args){
        new NumberTrick().go();
    }
    Scanner in = new Scanner(System.in);

    public void go(){
        double n = in.nextDouble();

        boolean hasresult = false;

        for (int j = 1; j < 10/n ; j++) {
            for (int k = 1; k < 8; k++) {


                for (int i = j* (int) Math.pow(10, k); i < j* (int) Math.pow(10, k + 1); i++) {
                    //System.out.println(i);
                    if (n * i == Wrap(i)) {
                        System.out.println(i);

                        hasresult = true;
                    }
                }
            }
        }




//        for (int i = (int)n; i < 100000000; i++){
//            if ( n * i == Wrap(i) ){
//                System.out.println(i);
//
//                hasresult = true;
//            }
//        }
//        }

        if (!hasresult) {System.out.println("No solution");}
    }

    public int Wrap(int x){
        //a method that takes 124532 and return 235321
        if (x/10 == 0) {return x;}

        else {
            for (int i = 1; i < 8; i++){
                if ( x/Math.pow(10,i) < 10) {
                    return (int) (x%Math.pow(10,i) * 10 + x/Math.pow(10,i)) ;
                }
            }
        }
        return 0;
    }


}
