import java.util.*;
/**
 * Created by Yubo on 9/9/15.
 *
 *
 *
 *


 4 3
 5 1 1 2
 5 2 2
 0 0

 */
public class ecna2014_A_ContinuedFractions {
    public static void main(String[] args){new ecna2014_A_ContinuedFractions().go();}
    Scanner in = new Scanner(System.in);

    private void go()
    {
        String[] line = in.nextLine().trim().split(" ");
        int total_a = Integer.parseInt(line[0]);
        int total_b = Integer.parseInt(line[1]);


        while (total_a + total_b != 0)
        {
            String[] line_a = in.nextLine().trim().split(" ");
            String[] line_b = in.nextLine().trim().split(" ");



            for ( String i : line_a)
            {
                System.out.printf("%s ", i);
            }
            System.out.println();

            for ( String i : line_b)
            {
                System.out.printf("%s ", i);
            }
            System.out.println();

            long a = Long.parseLong(line_a[0]);
            long b = Long.parseLong(line_b[0]);

            long frac_a = 0;

            for (int i = line_a.length-1; i>0; i--)
            {
                System.out.printf("frac_a = %f;\n", (float)frac_a);

                frac_a = (long)1/( frac_a + Long.parseLong(line_a[i]) ) ;
            }

            a += frac_a;

            long frac_b = 0;

            for (int i = line_b.length-1; i>0; i--)
            {
                System.out.printf("frac_b = %f;\n", (float)frac_b);

                frac_b = (long)1/( frac_b + Long.parseLong(line_b[i]) ) ;
            }

            b += frac_b;

            System.out.printf("d1 = %f ; d2 = %f ;\n", (float)a, (float)b);

            line = in.nextLine().trim().split(" ");
            total_a = Integer.parseInt(line[0]);
            total_b = Integer.parseInt(line[1]);
        }
    }
}
