import java.util.Scanner;

/**
 * Created by Yubo on 9/9/15.
 *
 *
 6 2 7 7 8 12 13
 1 4
 3 4 4 5
 3 0 4 5
 5 2 2  4 7 7
 0
 *
 */
public class mcpc2010_B_MadScientist {
    public static void main(String[] args){new mcpc2010_B_MadScientist().go();}
    Scanner in = new Scanner(System.in);

    public void go()
    {
        int total = in.nextInt();

        while (total != 0)
        {
            int prev = 0;
            int curr = 0;

            StringBuffer re = new StringBuffer();

            for (int num = 1; num <= total; num++)
            {
                curr = in.nextInt();
                for (int k = 0; k < curr-prev; k++){
                    re.append(num+ " ");
                }
                prev = curr;
            }
            total = in.nextInt();
            System.out.println(re.toString().substring(0, re.toString().length()-1));
        }

    }

}
