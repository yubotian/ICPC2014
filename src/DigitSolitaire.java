import java.util.Scanner;

/**
 * Created by Yubo on 9/5/15.
 */
public class DigitSolitaire {
    public static void main(String[] args)
    {
        new DigitSolitaire().go();
    }

    Scanner in = new Scanner(System.in);

    private void go()
    {
        int num = in.nextInt();
        while ( num != 0 )
        {
            solve(num);
            num = in.nextInt();
        }
    }

    private void solve(int num)
    {
        String num_s = Integer.toString(num);
        if (num_s.length() == 1)
        {
            System.out.printf("%s\n",num_s);
        }
        else
        {
            int re = 1;
            System.out.printf("%d ",num);
            for (int i = 0; i < num_s.length(); i++)
            {
                re *= Integer.parseInt((num_s.charAt(i)+""));
            }
            solve(re);
        }
    }
}
