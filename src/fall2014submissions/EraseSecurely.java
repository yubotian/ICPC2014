package fall2014submissions;

import java.util.Scanner;

/**
 * Created by Yubo on 11/11/14.
 */
public class EraseSecurely {
    public static void main(String[] args){
        new EraseSecurely().go();

    }
    Scanner in = new Scanner(System.in);

    public void go(){
        int n = in.nextInt();
        String a = in.nextLine().trim();
        String b = in.nextLine().trim();

        System.out.println(run(n,a,b));


    }

    public String run(int n, String a, String b){

        if (n%2 == 0){
            boolean re = true;



            for (int i =0; i < a.length() ;i++){
                if (a.charAt(i) != b.charAt(i)) {re = false;}
            }
            if (re){return "Deletion succeeded";}else{return "Deletion failed";}

        } else {
            boolean re = true;
            for (int i = 0; i< a.length(); i++){
                if (a.charAt(i) == b.charAt(i)){re = false;}
            }

            if (re){return "Deletion succeeded";}else{return "Deletion failed";}

        }
    }
}
