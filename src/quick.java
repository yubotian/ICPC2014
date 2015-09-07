import java.util.Scanner;

/**
 * Created by Yubo on 9/7/15.
 */
public class quick {

    public static void main(String[] args) {
        new quick().go();
    }

    public void go(){

        Scanner in = new Scanner(System.in);

        String alpha = "abcdefghijklmnopqrstuvwxyz";
        StringBuffer re = new StringBuffer();

        while (true){
            int k = in.nextInt();

            if (k == 0) break;

            re.append(alpha.charAt(k-1));
        }

        System.out.printf("%s",re.toString());
    }

}
