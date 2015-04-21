//nwerc_E.java


import java.util.*;

public class nwerc_E {
	public static void main(String[] args){
		new nwerc_E().go();
	}

	Scanner in = new Scanner(System.in);


    public void go() {
        
        int n = in.nextInt();
        double p = in.nextDouble();
        double s = in.nextDouble();
        double v = in.nextDouble();

        double a = 0.0, b = 100.0;

        while (b - a > 1e-12) {
            double c = a + 0.3 * (b - a);
            double d = b - 0.3 * (b - a);

            double time_c = ( s / v * (1 + 1/c) ) +
                (n * Math.pow(Math.log10(n) / Math.log10(2), c * Math.sqrt(2)) / p / Math.pow(10, 9)) ;

            double time_d = ( s / v * (1 + 1/d) ) +
                (n * Math.pow(Math.log10(n) / Math.log10(2), d * Math.sqrt(2)) / p / Math.pow(10, 9)) ;

            if (time_d > time_c) {
                b = d;
            } else {
                a = c;
            }
        }

        double time_a = ( s / v * (1 + 1/a) ) +
                (n * Math.pow(Math.log10(n) / Math.log10(2), a * Math.sqrt(2)) / p / Math.pow(10, 9)) ;

        System.out.printf("%.8f %.8f\n", time_a, a);

    }

}