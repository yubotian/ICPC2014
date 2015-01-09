package fall2014submissions; /**
 * Created by Yubo on 9/4/14.
 */
import java.util.Scanner;

public class StupidFly {
    Scanner scanner = new Scanner(System.in);

    public static void main(String[] args){ new StupidFly().go() ;}
/*
    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
*/
    public void go() {
        String temp = scanner.nextLine();
        int total = Integer.parseInt(temp.trim());
        int c = 0;

        while (c<total) {
            String ln = scanner.nextLine();
            String[] currln = ln.split(" ");

            Double[] dbln = new Double[4];
            int lnnum = Integer.parseInt(currln[0].trim());
            for (int i = 0; i < 4; i++) {
                dbln[i] = Double.parseDouble(currln[i+1].trim());
            }

            double result = dbln[3]*dbln[0]/(dbln[1]+dbln[2]);



            System.out.printf("%d %.2f\n",lnnum, result );

            c++;
            }
        }

    }


