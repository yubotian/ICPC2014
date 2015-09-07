import java.util.Scanner;

/**
 * Created by Yubo on 9/4/15.
 */
public class ReverseRot {

    String REF = "ABCDEFGHIJKLMNOPQRSTUVWXYZ_.ABCDEFGHIJKLMNOPQRSTUVWXYZ_.";

    public static void main(String[] args)
    {
        new ReverseRot().go();
    }


    Scanner in = new Scanner(System.in);

    void go()
    {
        int k = in.nextInt();
        while (k > 0)
        {
            String line = in.next().trim();
            StringBuffer re = new StringBuffer();
            for (int i = line.length()-1; i>= 0; i--)
            {
                re.append(REF.charAt(REF.indexOf(line.charAt(i))+k));
            }

            System.out.println(re.toString());


            k = in.nextInt();
        }
    }

}
