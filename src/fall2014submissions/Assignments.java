package fall2014submissions;

import java.util.Scanner;

/**
 * Created by Yubo on 9/2/14.
 */
public class Assignments {
    Scanner scanner = new Scanner(System.in);

    public static void main(String[] args){
        new Assignments().go();
    }

    public void go() {
        int cCases = scanner.nextInt();
        //    System.out.println("cCases = " + cCases);

        for (int i = 0; i < cCases; i++) {
            int count = 0;
            int cShips = scanner.nextInt();
            int dis = scanner.nextInt();
                      //System.out.println("cDis = " + dis + "\n" + "cShips = " + cShips);
            int[][] grid = new int[3][cShips + 1];


            for (int r = 1; r <= cShips; r++) {
                for (int n = 0; n < 3; n++) {
                    grid[n][r] = scanner.nextInt();
                                  //System.out.println("grid"+n+r +"is" + grid[n][r]);
                }


                    //System.out.println(" can reach = " + (double)grid[1][r]/grid[2][r] *(double)grid[0][r]);
                    if ((double) grid[1][r] / grid[2][r] * (double) grid[0][r] >= (double)dis) {
                        //System.out.println("count++");
                        count++;
                    }

                }
            System.out.println(count);
            }


        }

    }
