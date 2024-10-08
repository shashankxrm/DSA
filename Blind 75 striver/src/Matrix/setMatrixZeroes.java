package Matrix;

// LC 73 : Set Matrix Zeroes
// Given an m x n matrix. If an element is 0, set its entire row and column to 0. Do it in-place.
// Follow up:
// A straight forward solution using O(mn) space is probably a bad idea.
// A simple improvement uses O(m + n) space, but still not the best solution.
// Could you devise a constant space solution?
// Example 1:
// Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
// Output: [[1,0,1],[0,0,0],[1,0,1]]
// Input: matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
// Output: [[0,0,0,0],[0,4,5,0],[0,3,1,0]]

public class setMatrixZeroes {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean firstRowZero = false;
        boolean firstColZero = false;

        // Check if first row has a zero
        for(int j = 0; j < n; j++){
            if(matrix[0][j] == 0){
                firstRowZero = true;
                break;
            }
        }

        // Check if first col has a zero
        for(int i = 0; i < m; i++){
            if(matrix[i][0] == 0){
                firstColZero = true;
                break;
            }
        }

        // Check for zeros in the rest of the array
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                if(matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        // Nullify rows based on values in first column
        for(int i = 1; i < m; i++){
            if(matrix[i][0] == 0){
                for(int j = 1; j < n; j++){
                    matrix[i][j] = 0;
                }
            }
        }

        // Nullify columns based on values in first row
        for(int j = 1; j < n; j++){
            if(matrix[0][j] == 0){
                for(int i = 1; i < m; i++){
                    matrix[i][j] = 0;
                }
            }
        }

        // Nullify first row
        if(firstRowZero){
            for(int j = 0; j < n; j++){
                matrix[0][j] = 0;
            }
        }

        // Nullify first column
        if(firstColZero){
            for(int i = 0; i < m; i++){
                matrix[i][0] = 0;
            }
        }
    }
}
