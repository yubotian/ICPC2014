package spr2015submissions;//google_codejam_a.java


import java.util.Scanner;

public class google_codejam_a {

    public static void main(String args[]){ new google_codejam_a().go();}

    Scanner in  = new Scanner(System.in);


    public void go(){

        int total = in.nextInt();


        for (int i = 0; i < total; i++) {
            int max = in.nextInt();
            String data = in.next();
            char[] level = data.toCharArray();
            int result = 0;
            int standing = 0;
            for (int j = 0; j < max; j++) {
                standing += Math.abs('0' - level[j]);
                if (standing < j + 1) {
                    result++;
                    standing ++;
                }
            }

            System.out.printf("Case #%d: %d\n" , (i + 1) ,result);
        }

    }

}
