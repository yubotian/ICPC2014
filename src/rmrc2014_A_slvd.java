import java.util.Scanner;

/**
 * Created by Yubo on 1/26/15.
 *
 */

//Server

public class rmrc2014_A_slvd {
    Scanner in = new Scanner(System.in);

    public static void main (String args[]){
        new rmrc2014_A_slvd().go();
    }

    public void go(){
        int count = in.nextInt();
        int re = 0;

        int time = in.nextInt();
        while(count > 0) {
            count--;
            time -= in.nextInt();
            if (time >= 0) {
                re++;
                continue;
            } else {    break;
            }

        }
        System.out.println(re);
    }

}
