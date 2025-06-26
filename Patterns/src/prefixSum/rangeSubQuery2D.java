package prefixSum;

// LC304: Range Sum Query 2D - Immutable
// Given a 2D matrix matrix, handle multiple queries of the following type:
// Calculate the sum of the elements of matrix inside the rectangle defined by its upper left corner (row1, col1) and
// lower right corner (row2, col2).
// Implement the NumMatrix class:
// NumMatrix(int[][] matrix) Initializes the object with the integer matrix.
// int sumRegion(int row1, int col1, int row2, int col2) Returns the sum of the elements of matrix inside the rectangle
// defined by its upper left corner (row1, col1) and lower right corner (row2, col2) (i.e., sum of the elements
// matrix[row1][col1] + matrix[row1][col1 + 1] + ... + matrix[row2][col2]).
//ex1: Input: ["NumMatrix", "sumRegion", "sumRegion", "sumRegion"] [[[[3, 0, 1, 4, 2], [5, 6, 3, 2, 1], [1, 2, 0, 1, 5],
// [4, 1, 0, 1, 7], [1, 0, 3, 0, 5]]], [2, 1, 4, 3], [1, 1, 2, 2], [1, 2, 2, 4]] Output: [null, 8, 4, 15]
public class rangeSubQuery2D {
    private int[][] prefixSum;
    public rangeSubQuery2D(int[][] matrix) { // Time: O(m * n), Space: O(m * n)
        int m = matrix.length;
        if (m == 0) return;
        int n = matrix[0].length;
        prefixSum = new int[m + 1][n + 1];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                prefixSum[i + 1][j + 1] = prefixSum[i][j + 1] + prefixSum[i + 1][j] - prefixSum[i][j] + matrix[i][j];
            }
        }
    }
    public int sumRegion(int row1, int col1, int row2, int col2) {
        return prefixSum[row2 + 1][col2 + 1] - prefixSum[row1][col2 + 1] - prefixSum[row2 + 1][col1] + prefixSum[row1][col1];
    }
}
