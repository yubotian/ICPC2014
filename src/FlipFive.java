import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Yubo on 9/27/14.
 */



public class FlipFive {
    ArrayList<Point> blacks = new ArrayList<Point>();

    public static void main(String[] args){
        new FlipFive().start();
    }
    Scanner scanner = new Scanner(System.in);

    public void start() {
        int casenum = Integer.parseInt(scanner.nextLine());
        int casecount = 0;
        while (casecount < casenum) {
            casecount++;

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

            System.out.println(go(pattern, -1));

        }
    }

    public int go(char[][] pattern, int i){

        if (noBlack(pattern)){ return 1;}  //base case
        else {
            for (int j = i + 1; j < blacks.size(); j++) {
                char[][] newpattern = flip(pattern, blacks.get(i+1).x, blacks.get(i+1).y);
                return go(newpattern, i+1) + 1;
            }
        }
        return 0;
    }


    public char[][] flip(char[][] pattern, int i,int j){
        char[][] newpattern = new char[3][3];
        newpattern[i][j] = opposite(pattern[i][j]);
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
        if (c == '.'){ return'*';}
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
