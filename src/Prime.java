import java.util.Scanner;

/**
 * Created by Yubo on 9/14/14.
 */
public class Prime {
    Scanner scanner = new Scanner(System.in);

    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        int length = s.length();


        StringBuffer buffer = new StringBuffer(s);
        buffer.reverse();




        if(s.equals(buffer.toString())){System.out.println("true");}
        else {System.out.println("false");}



    }
}

