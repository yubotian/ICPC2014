import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.Scanner;
import java.util.List;

/**
 * Created by Yubo on 9/22/14.
 */
public class Pikachu {
    public static void main(String[] args){
        new Pikachu().go();
    }
    Scanner scanner = new Scanner(System.in);
    public void go(){

        while (true){
            boolean t = true;
            String n = scanner.nextLine();
            if (n.equals("foo")){
                break;
            }

            if (n.matches("((pi)|(ka)|(chu))*"))System.out.println("YES");
            else System.out.println("NO");




        }


    }
}
