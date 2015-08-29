package spr2015submissions;

import java.util.Scanner;

/**
 * Created by Yubo on 2/2/15.
 */
public class rmrc2014_B_slvd {

    public static void main(String[] args) {
        new rmrc2014_B_slvd().go();
    }

    Scanner in = new Scanner(System.in);

    private void go() {

        int count=in.nextInt();

        for(int c = 0 ; c < count; c++){
            String name= in.next();
            String collegeyear = in.next().split("/")[0];
            String birthyear = in.next().split("/")[0];

            int cy = Integer.parseInt(collegeyear);
            int by = Integer.parseInt(birthyear);

            int courses= in.nextInt();
            if(cy >= 2010){
                System.out.printf("%s eligible\n",name);
                continue;
            }
            if(by >= 1991){
                System.out.printf("%s eligible\n",name);
                continue;
            }
            if(courses>=41){
                System.out.printf("%s ineligible\n",name);
                continue;
            }
            System.out.printf("%s coach petitions\n", name);
        }
    }
}
