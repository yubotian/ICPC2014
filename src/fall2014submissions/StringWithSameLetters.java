package fall2014submissions;

import java.util.Scanner;
import java.util.Arrays;
/**
 * Created by Yubo on 9/18/14.
 */
public class StringWithSameLetters {
    public static void main(String[] args){
        new StringWithSameLetters().go();
    }
    Scanner scanner = new Scanner(System.in);

    public void go(){
        int count = 0;
        while (true){
            String stra =scanner.nextLine().trim();
            String strb =scanner.nextLine().trim();
            if (stra.equals("END")){
                //  System.out.println("break");
                break;}
            count ++;
            boolean t = true;
            char[] a =stra.toCharArray();
            char[] b =strb.toCharArray();
            Arrays.sort(a);
            Arrays.sort(b);
            System.out.printf("Case %d: ", count);
            int x = a.length;
            if (b.length < x) {x = b.length;}
            for (int i = 0; i< x ;i++){
                if (a[i] != b[i]) {t = false;}
            }
            if (t){System.out.println("same");} else {System.out.println("different");}
        }
    }
}
