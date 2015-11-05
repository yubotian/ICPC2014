/**
 * Created by Yubo on 9/26/15.
 */
public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        int row = matrix.length;
        int col = matrix[0].length;

        int hi = col*row-1;
        int lo = 0;

        while (lo <= hi){
            int mid = (hi+lo)/2;


            if (matrix[mid/col][mid%col] == target){
                return true;
            }
            else if (matrix[mid/col][mid%col] > target){
                hi = mid-1;
            }
            else {
                lo = mid+1;
            }
        }

        return false;

    }


    public static void main(String[] args){
        int [][] matrix = new int[1][1];

        matrix[0][0] = 1;


        new Solution().searchMatrix(matrix,0);
    }
}