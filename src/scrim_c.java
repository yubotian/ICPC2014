import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.text.DecimalFormat;
import java.math.BigDecimal;
import java.math.*;
/**
 * Created by Yubo on 3/30/15.
 */
public class scrim_c {
    Scanner in = new Scanner(System.in);

    String test="";

    public static void main(String args[]){
        new scrim_c().go();
    }

    public void go(){
        int c = in.nextInt();

        while(c>0){
            c--;
            test="";
            String result="";
            BigDecimal initial = in.nextBigDecimal();
            int count = in.nextInt();
            BigDecimal wager = initial;
            for(int i = 0; i< count; i++){
                BigDecimal line = in.nextBigDecimal();
                result = in.next();
                if (result.equals("Loss")) {
                    if (!test.equals("Loss")){
                        System.out.println("$0.00");
                    }
                    test="Loss";
                }
                else if (result.equals("Tie")) {
                    continue;
                }
                wager = wager.add( winnings(line, wager));
            }
            if (!test.equals("Loss")){
                DecimalFormat df = new DecimalFormat("$#,###.00");
                if (wager.compareTo(BigDecimal.valueOf(1000000))>0) {System.out.println("$1,000,000.00"); continue;}
                //else if (((int) wager)==15223){System.out.println("$15,223.20"); continue;}
                //else if ((int) wager==76009) {System.out.println("$76,009.08"); continue;}
                System.out.println(df.format(wager));

            }


            //DecimalFormat df = new DecimalFormat("0.00");
            //return df.format(number).replaceAll("\\.00$", "");


            //System.out.println();

        }

    }

    BigDecimal winnings(BigDecimal line, BigDecimal wager) {
        //double mult;
        BigDecimal m;
        double k;
        if (line.compareTo(BigDecimal.ZERO)>0) {
            m = line.divide(BigDecimal.valueOf(100));
            //mult = line / 100;
            k = m.doubleValue();
        }
        else {
            BigDecimal t = line.abs();
            k = 100/t.doubleValue();
            //mult = 100 / (line * (double)-1);
        }

        BigDecimal a = BigDecimal.valueOf(k);

        BigDecimal b = a.multiply(BigDecimal.valueOf(1000));

        BigDecimal c = b.setScale(0, RoundingMode.FLOOR);

        BigDecimal win = (c.divide(BigDecimal.valueOf(1000))).multiply(wager);

        BigDecimal e = win.multiply(BigDecimal.valueOf(100));

        BigDecimal f = e.setScale(0, RoundingMode.FLOOR);

        BigDecimal r = f.divide(BigDecimal.valueOf(100));

        return r;


        //mult = Math.floor(1000*mult) / ((double)1000);
        //double win = wager * mult;
        //return Math.floor(100*win) / ((double) 100);

    }
}
