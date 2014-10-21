import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Yubo on 9/17/14.
 */
public class GoodVersusEvil {
    Scanner scanner = new Scanner(System.in);

    public static void main(String[] args){
        new GoodVersusEvil().go();
    }

    private void go(){
        int battle = scanner.nextInt();
        int count = 0;
        Integer[] goodforce = {1,2,3,3,4,10};
        Integer[] evilforce = {1,2,2,2,3,5,11};
        while (count != battle) {

            count += 1;
            int g = 0;
            int e = 0;
            for (int i = 0; i < 6; i++) {

                g += goodforce[i] * scanner.nextInt();
            }
            for (int i = 0; i < 7; i++) {
                e += evilforce[i] * scanner.nextInt();
            }
            System.out.printf("Battle %d: ",count);
            if(g>e)System.out.println("Good triumphs over Evil");
            if(e>g)System.out.println("Evil eradicates all trace of Good");
            if(e==g)System.out.println("No victor on this battle field");
        }
    }
}