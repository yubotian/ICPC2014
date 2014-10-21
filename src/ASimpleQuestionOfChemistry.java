import java.util.Scanner;

/**
 * Created by Yubo on 9/29/14.
 */
public class ASimpleQuestionOfChemistry {
    Scanner scanner = new Scanner(System.in);
    public static void main (String[] args){
        new ASimpleQuestionOfChemistry().go();
    }
    public void go(){
        float prev = scanner.nextFloat();
        float curr = scanner.nextFloat();
        while (curr != 999){
            float diff = curr - prev;
            System.out.printf("%.2f\n", diff);
            prev = curr;
            curr = scanner.nextFloat();

        }
        System.out.println("End of Output");
    }

}
