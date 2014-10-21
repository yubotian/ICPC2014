package APT201;

import java.util.Arrays;


public class RatRoute {

    private char[][] myGrid;
    private int myRows,  myCols  ;
    private int myCheeseRow, myCheeseCol;
    
    public int numRoutes(String[] enc){
        
        myRows = enc.length;
        myCols = enc[0].length();
        myGrid = new char[myRows][myCols];

        System.out.println(myGrid);
        
        int ratRow=0,ratCol=0;
        for(int r=0; r < myRows;  r++){
            Arrays.fill(myGrid[r], '.');
         
            for(int c=0; c < myCols; c++){
                char ch = enc[r].charAt(c);
                if (ch == 'R'){
                    ratRow = r; ratCol = c;
                }
                else if (ch == 'C'){
                    myCheeseRow = r; myCheeseCol = c;
                    myGrid[r][c] = 'C';
                }
                else if (ch == 'X'){
                    myGrid[r][c] = 'X';
                }
            }
        }
        
        int currentDistance = cheeseDistance(ratRow,ratCol);
        return routeCount(ratRow,ratCol, currentDistance+1);
    }

    private int cheeseDistance(int row, int col) {
    	return Math.abs(row-myCheeseRow) + Math.abs(col-myCheeseCol);
    }

    private int routeCount(int row, int col, int lastDistance){
        
        if (row < 0 || col < 0 || row >= myRows || col >= myCols) return 0;
        if (myGrid[row][col] == 'C') return 1;
        if (myGrid[row][col] == 'X') return 0;
        
        if (lastDistance < cheeseDistance(row,col))
        	return 0;
        return routeCount(row-1,col,lastDistance-1) + routeCount(row,col-1,lastDistance-1) + routeCount(row+1,col,lastDistance-1) + routeCount(row,col+1,lastDistance-1);
        
    }
    public static void main(String[] enc){
   	 RatRoute NR = new RatRoute();
   	 String[] enclosure = {
   			 ".R...",
   			 "..X..",
   			 "....X",
   			 "X.X.X",
   			 "...C."};
   	 int result = NR.numRoutes(enclosure);
   	 System.out.println(result);
   	 
    }


}
