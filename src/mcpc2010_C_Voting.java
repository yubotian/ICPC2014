import java.util.Scanner;

/**
 * Created by Yubo on 9/8/15.
 */
public class mcpc2010_C_Voting {
    public static void main(String[] args){new mcpc2010_C_Voting().go();}

    Scanner in = new Scanner(System.in);

    private void go()
    {
        String line = in.nextLine().trim().toString();
        while (true)
        {
            if (line.charAt(0) == '#') return;

            int total = line.length();

            int absent = 0;
            int yes = 0;
            int no = 0;

            for (int i = 0; i< line.length(); i++) {
                switch (line.charAt(i)) {
                    case ('Y'):
                        yes++;
                        break;
                    case ('N'):
                        no++;
                        break;
                    case ('A'):
                        absent++;
                        break;
                }
            }

            String result = absent * 2 >= total ? "need quorum" : (yes == no ? "tie" : (yes > no ? "yes" : "no"));
            System.out.println(result);

            line = in.nextLine().trim().toString();

        }
    }

}
