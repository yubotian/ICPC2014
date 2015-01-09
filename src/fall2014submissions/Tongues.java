package fall2014submissions;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Yubo on 9/18/14.
 */
public class Tongues {
    public static void main(String[] args){
        new Tongues().go();
    }
    String vc = "aAiIyYeEoOuUbBkKxXzZnNhHdDcCwWgGpPvVjJqQtTsSrRlLmMfF";
    String newVC = "eEoOuUaAiTyYpPvVjJqQtTsSrRlLmMfFbBkKxXzZnNhHdDcCwWgG";
   // String con =    "";
   // String newCon = "pPvVjJqQtTsSrRlLmMfFbBkKxXzZnNhHdDcCwWgG" ;
    char[] vc1 = vc.toCharArray();


    Scanner scanner = new Scanner(System.in);

    public void go() {

        while (scanner.hasNextLine()) {
            String str = scanner.nextLine();
            ArrayList<Character> re= new ArrayList<Character>();
            str.trim();
            char[] temp = str.toCharArray();

            for (int i = 0; i < str.length(); i++) {
                if (vc.indexOf(temp[i]) == -1   ){re.add(temp[i]);}
                else {
                char t = newVC.charAt(vc.indexOf(temp[i]));
                re.add(t);
                }
            }
            StringBuilder sb = new StringBuilder();
            for (char s : re)
            {
                sb.append(s);

            }

            System.out.println(sb.toString());
        }

    }



}
