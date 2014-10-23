import java.util.*;
/**
 * Created by Yubo on 10/23/14.
 */
public class GCD {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.println("Enter first/second int");
        int x = in.nextInt();
        int y = in.nextInt();
        System.out.printf("GCD is : %d", go(x,y) );

    }

    public static int go(int a, int b){

        if (a == 0)
            return b;

            while (a != b)
            {
                if (a > b)
                    a = a - b;
                else if (b > a)
                    b = b - a;
                else
                    return a;
            }
            return a;
        }



}
