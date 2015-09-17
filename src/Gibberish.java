import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Yubo on 9/10/15.
 */
public class Gibberish {
    public static void main(String[] args){ new Gibberish().go();}
    Scanner in = new Scanner(System.in);

    private String KEY_MAP = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890!?/@#$%,.^&*()_+";
    private String DIC_MAP = ")+DP9!Ho&TBdzJWm.LVkZScuhwEfvGxiQaMCpjR^,leI6%@qsX0$r/tn4*N#Y?(y87Ag5K3bUO1F_2";
    private String HEADER = "`;|}";
    private void go(){

        // TODO: re-randomize dic_map every x min
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Calendar cal = Calendar.getInstance();
        System.out.println(dateFormat.format(cal.getTime()));

        while(true){
            String line = in.nextLine().trim();

            if (line.equals("exit"))
            {
                System.out.println("LOVE YOU.");
                return;
            }

            if (line.length()==0){
                continue;
            }

            StringBuffer buf = new StringBuffer();

            // encode
            if (HEADER.indexOf(line.charAt(0)) == -1)
            {
                Random randomGenerator = new Random();

                int randomInt = randomGenerator.nextInt(HEADER.length());

                buf.append(HEADER.charAt(randomInt));

                for (int i = 0; i<line.length();i++)
                {
                    int k = DIC_MAP.indexOf(line.charAt(i));
                    buf.append(k == -1 ? line.charAt(i) : KEY_MAP.charAt(k));
                }
                System.out.println(buf.toString());

            }

            // decode
            else {

                for (int i = 1; i<line.length();i++)
                {
                    int k = KEY_MAP.indexOf(line.charAt(i));

                    buf.append( k == -1 ? line.charAt(i) : DIC_MAP.charAt(k));
                }

                System.out.println(buf.toString());
            }
        }
    }
}
