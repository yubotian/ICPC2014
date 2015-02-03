/*
 * Created by Yubo on 1/26/15.
 *
 * use randomnized algorithm
 *
 * solution1:
 * pick two points at random, and check
 * 1-1.8^-18
 *
 * solution2:
 * divide and conquer
 *
 * run n^2 on sub parts of the whole problem
 * produce candidates line (a candidate ine covers more than 20% of whatever group you are looking at)
 *
 * runtime
 *
 */

import java.util.Scanner;

public class nwerc2014_F_slvd {
    // use randomization

    public static void main(String[] args){
        new nwerc2014_F_slvd().go();
    }

    Scanner in = new Scanner(System.in);

    private void go(){

        int num_pts = in.nextInt();
        int c = num_pts;
        int per = in.nextInt();

        if (num_pts == 1 || num_pts == 2){
            System.out.println("possible");
            return;
        }


        int[][] my = new int[num_pts][2];
        while (num_pts>0){
            num_pts --;
            my[num_pts][0] = in.nextInt();
            my[num_pts][1] = in.nextInt();
        }
        int t = 500;

        while(t>0){
            t--;
            int r = (int)(Math.random()*c);
            int q = (int)(Math.random()*c);
            while (r == q){
                q = (int)(Math.random()*c);
            }

            int count = pts_on_line(r,q,my);

            if ( 100*count/c >= per) {
                //System.out.printf("count : %d, count*11/c: %d,  per : %d\n", count, 100*count/c, per);
                System.out.println("possible");
                return;
            }
        }
        System.out.println("impossible");
    }

    private int pts_on_line(int r, int q, int[][]my){
        int count = 2;

        for (int i = 0; i< my.length; i++){
            if (i != r && i != q){

                //System.out.printf("%d,%d,%d\n",r,q,i);
                int x1 = my[r][0]; int y1 = my[r][1];
                int x2 = my[q][0]; int y2 = my[q][1];
                int x3 = my[i][0]; int y3 = my[i][1];

                if ( ((y1-y3)*(x1-x2) ) == ((y1-y2)*(x1-x3)) ){
                    //System.out.printf("Count: point1 (%d, %d) point2 (%d, %d) point3 (%d, %d)\n", x1,y1,x2,y2,x3,y3);
                    count ++;
                }
            } else {//donothing
             }
        }

        return count;
    }
}
