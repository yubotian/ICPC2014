package fall2014submissions;

import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Yubo on 9/27/14.
 */
public class Q4_FlipFive {
    public static void main(String[] args) {
        new Q4_FlipFive().start();

    }
    Scanner scanner = new Scanner(System.in);

    public void start() {
        int casenum = Integer.parseInt(scanner.nextLine());
        int casecount = 0;
        while (casecount < casenum) {
            casecount++;
            go();
        }
    }

    public void go(){
        ArrayList<Point> blacks = new ArrayList<Point>();
        char[][] pattern = new char[3][3];
        pattern[0] = scanner.nextLine().trim().toCharArray();
        pattern[1] = scanner.nextLine().trim().toCharArray();
        pattern[2] = scanner.nextLine().trim().toCharArray();

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (pattern[i][j] == '*') {
                    blacks.add(new Point(i, j));
                }
            }
        }

        if (noBlack(pattern)){System.out.println(0);
        return;}


        for (int i = 0; i < blacks.size(); i++) {
            char[][] newpattern = flip(pattern, blacks.get(i).x, blacks.get(i).y);
            if (noBlack(newpattern)){
                System.out.println(1);
                return;
            }
        }


        for (int i = 0; i < blacks.size(); i++) {
            char[][] newpattern = flip(pattern, blacks.get(i).x, blacks.get(i).y);
            for (int j = i+1; j < blacks.size(); j++) {

                newpattern = flip(newpattern, blacks.get(j).x, blacks.get(j).y);
                if (noBlack(newpattern)){
                    System.out.println(2);
                    return;
                }

            }
        }



        for (int i = 0; i < blacks.size(); i++) {
            char[][] newpattern = flip(pattern, blacks.get(i).x, blacks.get(i).y);

            for (int j = i+1; j < blacks.size(); j++) {
                newpattern = flip(newpattern, blacks.get(j).x, blacks.get(j).y);

                for (int k = j + 1; k < blacks.size(); k++) {



                    newpattern = flip(newpattern, blacks.get(k).x, blacks.get(k).y);
                    if (noBlack(newpattern)) {
                        System.out.println(3);
                        return;
                    }

                }
            }
        }

        for (int i = 0; i < blacks.size(); i++) {
            char[][] newpattern = flip(pattern, blacks.get(i).x, blacks.get(i).y);

            for (int j = i+1; j < blacks.size(); j++) {
                newpattern = flip(newpattern, blacks.get(j).x, blacks.get(j).y);

                for (int k = j + 1; k < blacks.size(); k++) {
                    newpattern = flip(newpattern, blacks.get(k).x, blacks.get(k).y);

                    for (int l = k+1; l< blacks.size(); l++) {
                        newpattern = flip(newpattern, blacks.get(l).x, blacks.get(l).y);
                        if (noBlack(newpattern)) {
                            System.out.println(4);
                            return;
                        }
                    }
                }
            }
        }

        System.out.println(5);
        return;



    }

    public char[][] flip(char[][] pattern, int i,int j){
        char[][] newpattern = new char[3][3];
        newpattern[i][j] = '.';
        if (i == 0){newpattern[i+1][j] = opposite(pattern[i+1][j]);}
        if (i == 2){newpattern[i-1][j] = opposite(pattern[i-1][j]);}
        if (i == 1){newpattern[i+1][j] =  opposite(pattern[i+1][j]);
            newpattern[i-1][j] = opposite(pattern[i-1][j]);}
        if (j == 0){newpattern[i][j+1] = opposite(newpattern[i][j+1]);}
        if (j == 2){newpattern[i][j-1] = opposite(newpattern[i][j-1]);}
        if (j == 1){newpattern[i][j+1] = opposite(newpattern[i][j+1]);
            newpattern[i][j-1] = opposite(newpattern[i][j-1]);}
        for (int q=0;q<3;q++){
            for (int w = 0;w<3;w++){
                if (newpattern[q][w] != '.' && newpattern[q][w] != '*'  ){newpattern[q][w] = pattern[q][w];}
            }
        }
        return newpattern;

    }

    public char opposite(char c){
        if (c=='.'){ return'*';}
        else {return '.';}
    }

    public boolean noBlack(char[][]pattern){
        for (int q=0;q<3;q++){
            for (int w = 0;w<3;w++){
                if (pattern[q][w] == '*'){return false;}
            }
        }
        return true;
    }
}
