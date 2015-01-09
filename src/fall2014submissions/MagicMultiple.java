package fall2014submissions;

import java.util.HashSet;
import java.util.Scanner;

/**
 * Created by Yubo on 9/18/14.
 */

public class MagicMultiple {
    public static void main(String[] args) {
        new MagicMultiple().go();
    }

    Scanner scanner = new Scanner(System.in);

    public void go() {
        while (scanner.hasNext()) {
            //ArrayList<Integer> std = new ArrayList<Integer>();
            int k = 1;
            long n = scanner.nextLong();
            HashSet<Character> hs = new HashSet<Character>();
            while (hs.size() != 10) {
               char[] test = Long.toString(n*k).toCharArray();
               //System.out.println(test.toString());
               for (char i:test){hs.add(i);}
               k++;
            }
            System.out.println(k-1);
        }
    }
}
