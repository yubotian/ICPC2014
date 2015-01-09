package fall2014submissions; /**
 * Created by Yubo on 9/3/14.
 */
import java.util.Scanner;

public class DataIsland {
    Scanner scanner = new Scanner(System.in);

    public static void main(String[] args){new DataIsland().go();}

    public void go(){
        String temp = scanner.nextLine();
        int total = Integer.parseInt(temp.trim());
        int c = 0;
        
        while (c<total) {
            String ln = scanner.nextLine();
            String[] currln = ln.split(" ");
            int count = 0;

            Integer[] intln = new Integer[currln.length];
            for (int i = 0; i < currln.length; i++) {
                intln[i] = Integer.parseInt(currln[i].trim());
            }
            for (int i = 1; i < intln.length - 1; i++) {
                if (intln[i] < intln[i + 1]) {
                    count++;
                }
            }

        System.out.println(intln[0]+" "+count);
            c++;



        }




    }
}
