import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Yubo on 9/29/14.
 */
public class SpellingBe {
    public static void main(String[] args){
        new SpellingBe().go();

    }
    Scanner scanner = new Scanner(System.in);
    private void go(){
        int dicttl = Integer.parseInt(scanner.nextLine());
        int diccount = 0;
        String[] dic = new String[dicttl];
        while (diccount < dicttl){
            dic[diccount] = scanner.nextLine().trim();
            diccount++;
        }



        int emailttl =Integer.parseInt(scanner.nextLine());
        int emailcount = 0;
        while(emailcount<emailttl){
          //  int emailnum = scanner.nextInt();
            String str = scanner.nextLine().trim();
            emailcount++;
            boolean alreadyWrong = false;
            boolean hasMis = false;
            while (!str.equals("-1")){

                if (!Arrays.asList(dic).contains(str)){
                    // print "email x has spelled worng " but only once,   then print the wrong word
                    hasMis = true;
                    if (!alreadyWrong){System.out.printf("Email %d is not spelled correctly.\n", emailcount);
                    alreadyWrong = true;}
                    System.out.println(str);
                }
                str = scanner.nextLine().trim();
            }
            if (!hasMis) {System.out.printf("Email %d is spelled correctly.\n", emailcount);}

        }
        System.out.println("End of Output");
    }

}
