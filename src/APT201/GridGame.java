package APT201;

public class GridGame {
     public int winningMoves(String[] grid){
    	 char[][] myGrid = new char[4][4];
 
    	 for(int i=0; i<4; i++){
             for(int j=0; j<4; j++){
            	 myGrid[i][j] = grid[i].charAt(j);
             }
    	 }
    	 int wins = countWins(myGrid);
    	 return wins;
     }
     
     public int countWins(char[][] myGrid){
             int wins = 0;
             
             for(int i=0; i<4; i++){
                     for(int j=0; j<4; j++){
                    	 
                                     if(safeToPlace(i,j,myGrid)){
                                             myGrid[i][j] = 'X';
                                             int opponentWins =countWins(myGrid);
                                             if(opponentWins==0){
                                                     wins++;
                                             }
                                             myGrid[i][j] = '.';
                                     }
                             }
                     
                     }
             return wins; 
             }
     
     
     public boolean safeToPlace(int r, int c, char[][] myGrid){
             if (myGrid[r][c] == 'X') return false;
             if (r>0 && myGrid[r-1][c] == 'X') return false;
             if (r<3 && myGrid[r+1][c] == 'X') return false;
             if (c>0 && myGrid[r][c-1] == 'X') return false;
             if (c<3 && myGrid[r][c+1] == 'X') return false;
             else return true;}
     
     public static void main(String[] args){
       GridGame gg = new GridGame();
       String[] test1 = {".X.X", "X...", ".X.X", "X.X."};
       int result1 = gg.winningMoves(test1);
       System.out.println(result1);
}
}