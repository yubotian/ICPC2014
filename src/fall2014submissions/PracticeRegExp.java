package fall2014submissions;

import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * Created by Yubo on 9/23/14.
 */
public class PracticeRegExp {
    public static void main(String[] args){
        new PracticeRegExp().go();

    }

    Scanner s = new Scanner(System.in);                 //alt + return to import lib

    public void go(){
        String str = "acmghmgh";
        boolean t = str.matches("^acm.*");
        System.out.println(t);
        boolean l = str.matches(".*ger$");
        System.out.println(l);
        boolean m = str.matches("[ahg].*");
        System.out.println(m);

        //      \d any digits, \D any non-digits, \s any whitespace character, \S non white space, \w shortfor [a-zA-Z_0-9]
        //  x? once or not at all || x* zero or more times || x+ one or more times || x{n} exactly n times || x{n,} more than n
        // x{n,m} x occurs at least n at most m tiems


        System.out.println(Pattern.matches("[a-eA-E1-4]*", "ABCDCacdtb12221" ));   //matches ranges
        System.out.println(Pattern.matches("[^a-e]*", "ABCDC454336546784" ));      //when ^ is in [] = not
        System.out.println(Pattern.matches("[pi|ka|chu]*", "pipipipikachuchuchukapikachu" ));    //matches or



    }
}
