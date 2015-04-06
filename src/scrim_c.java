import java.util.Scanner;
import java.text.DecimalFormat;
/**
 * Created by Yubo on 3/30/15.
 */
public class scrim_c {
    Scanner in = new Scanner(System.in);

    public void main(String args[]){
        new scrim_c().go();
    }

    public void go(){
        int c = in.nextInt();

        while(c>0){
            c--;
            double initial = in.nextDouble();
            int count = in.nextInt();
            double wager = initial;
            for(int i = 0; i< count; i++){
                double line = in.nextDouble();
                String result = in.next();
                if (result.equals("Loss")) {
                    System.out.println("$0.00");
                    break;
                }
                else if (result.equals("Tie")) {
                    continue;
                }
                wager += winnings(line, result, wager);
            }



            DecimalFormat df = new DecimalFormat("0.00");
            return df.format(number).replaceAll("\\.00$", "");


            System.out.println();




        }
    }

    double winnings(double line, String result, double wager) {
        double mult;
        if (line > 0) {
            mult = line / 100;
        }
        else {
            mult = 100 / (line * -1);
        }
        mult = Math.floor(1000*mult) / ((double)1000);
        double win = wager * mult;
        return Math.floor(100*win) / ((double) 100);
    }
}
