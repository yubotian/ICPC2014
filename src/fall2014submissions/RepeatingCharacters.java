package fall2014submissions;

import java.util.Scanner;
/**
 * Created by Yubo on 9/22/14.
 */
public class RepeatingCharacters {
    public static void main(String[] args){
        new RepeatingCharacters().go();

    }
    Scanner scanner = new Scanner(System.in);

    public void go(){
        int count = 0;
        int total = scanner.nextInt();

        while (count<total){
            count = scanner.nextInt();
            int times = scanner.nextInt();
            String temp = scanner.next().trim();

            char[] sar = temp.toCharArray();
            StringBuilder result =new StringBuilder("");
            for (int i = 0; i < sar.length ;i++) {
                for (int c = 0; c<times; c++){result.append(sar[i]);}
            }

            System.out.printf("%d %s", count, result.toString());
        }

    }
}
