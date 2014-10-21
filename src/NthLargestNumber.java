import java.util.Scanner;
import java.util.Arrays;

/**
 * Created by Yubo on 9/29/14.
 */
public class NthLargestNumber {
    Scanner scanner = new Scanner(System.in);
    public static void main(String[] args){
        new NthLargestNumber().go();
    }
    public void go(){
        int ttl = scanner.nextInt();
        int count = 0;
        while (count<ttl){
            count++;
            int tmp = 0;
            int casenum = scanner.nextInt();
            int a[] = new int[10];
            while (tmp < 10){
                a[tmp] = scanner.nextInt();
                tmp++;
            }
            Arrays.sort(a);
            System.out.println(count + " " + a[7]);

        }

    }
}

