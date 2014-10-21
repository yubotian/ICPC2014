/**
 * Created by Yubo on 9/2/14.
 */

import java.util.*;


public class PerfectNumber{
    public static String  PerfectNumber(int target) {
        String posiDivisors = "";
        int testNum = 0;
        for (int i = 1 ; i <=target/2 ; i++ ){
            if (target%i == 0){
                testNum += i;

                posiDivisors = posiDivisors +  " + " + i ;
            }
        }

        if (testNum == target){
            return target + " = " + posiDivisors.substring(3) ;

        } else {
            return target + " is NOT perfect.";

        }
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int num;
        while((num = scanner.nextInt()) != -1){
            System.out.println(PerfectNumber(num));


        }
    }
}

