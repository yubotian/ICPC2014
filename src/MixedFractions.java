import java.util.Scanner;

/**
 * Created by Yubo on 9/27/14.
 */
public class MixedFractions {
    public static void main(String[] args){
        new MixedFractions().go();
    }
    Scanner scanner = new Scanner(System.in);
    public void go(){
        while(true) {
            int i = scanner.nextInt();
            int j = scanner.nextInt();
            if (i == 0) {
                if (j == 0) {
                    break;
                } else {
                    System.out.printf("0 0 / %d", j);
                }
            } else {
                int k = i / j;
                int l = i % j;
                System.out.printf("%d %d / %d", k, l, j);
            }
        }

    }
}
