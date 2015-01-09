package fall2014submissions;

import java.util.Scanner;

/**
 * Created by Yubo on 10/1/14.
 */
public class FillingOutTheTeam {
    public static void main(String [] args){
        new FillingOutTheTeam().go();
    }
    Scanner scanner = new Scanner(System.in);
    public void go(){
        while(true) {
            double a = scanner.nextDouble();
            double b = scanner.nextDouble();
            double c = scanner.nextDouble();
            if (a == 0 & b == 0 & c == 0) {
                break;
            }
            boolean hasPosition = false;
            String pos = "";
            if (a <= 4.5 & b >= 150 & c >= 200) {
                pos = pos + "Wide Receiver ";
                hasPosition = true;
            }
            if (a <= 6.0 & b >= 300 & c >= 500) {
                pos = pos + "Lineman ";
                hasPosition = true;
            }
            if (a <= 5.0 & b >= 200 & c >= 300) {
                pos = pos + "Quarterback ";
                hasPosition = true;
            }
            if (!hasPosition) {
                pos = pos + "No positions";
            }
            System.out.println(pos);
        }
    }
}
