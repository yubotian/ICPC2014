package fall2014submissions;

import java.util.Scanner;

/**
 * Created by Yubo on 9/26/14.
 */
public class IntToString {
    public static void main(String[] args) {
        new IntToString().go();
    }

    Scanner scanner = new Scanner(System.in);

    public void go() {

        int n = scanner.nextInt();
        StringBuffer buffer = new StringBuffer();
        boolean isNegative = false;

        if (n<0){
            isNegative = true;
            n = -n;
        }
        while (true) {
            if (n / 10 == 0) {
                buffer.append(n%10);
                break;

            } else {
                buffer.append(n%10);
                n = n/10;
            }
        }

        if (isNegative){buffer.append('-');}
        System.out.println(buffer.reverse().toString());



    }

}