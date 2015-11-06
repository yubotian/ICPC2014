import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Yubo on 11/5/15.
 */
public class qual2012_QuitaProblem {
    public static void main(String[] args){new qual2012_QuitaProblem().go();}
    Scanner in = new Scanner(System.in);

    void go(){
        String pattern = "^(.*)problem(.*)";
        Pattern r = Pattern.compile(pattern);

        while(in.hasNext()){
            String line = in.nextLine().toLowerCase();
            Matcher m = r.matcher(line);
            System.out.printf( m.find() ? "yes\n":"no\n");
        }
    }

}
