package dfs;

// LC329: Longest Increasing Path in a Matrix
// Given an m x n integers matrix, return the length of the longest increasing path in matrix.
// From each cell, you can either move to four directions: left, right, up, or down. You may not move diagonally or move
// outside the boundary (i.e., wrap-around is not allowed).
// Example 1: Input: matrix = [[9,9,4],[6,6,8],[2,1,1]]
// Output: 4 Explanation: The longest increasing path is [1, 2, 6, 9].
public class largestIncPathInAmatrix {
    public int longestIncreasingPath(int[][] matrix) { // Time: O(m * n), Space: O(m * n)
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[m][n]; // Memoization array
        int maxLength = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                maxLength = Math.max(maxLength, dfs(matrix, dp, i, j));
            }
        }
        return maxLength;
    }
    private int dfs(int[][] matrix, int[][] dp, int i, int j) {
        if (dp[i][j] != 0) return dp[i][j]; // Return cached result
        int m = matrix.length, n = matrix[0].length;
        int maxPath = 1; // At least the cell itself

        // Explore all four directions
        if (i > 0 && matrix[i - 1][j] > matrix[i][j]) { // Up
            maxPath = Math.max(maxPath, 1 + dfs(matrix, dp, i - 1, j));
        }
        if (i < m - 1 && matrix[i + 1][j] > matrix[i][j]) { // Down
            maxPath = Math.max(maxPath, 1 + dfs(matrix, dp, i + 1, j));
        }
        if (j > 0 && matrix[i][j - 1] > matrix[i][j]) { // Left
            maxPath = Math.max(maxPath, 1 + dfs(matrix, dp, i, j - 1));
        }
        if (j < n - 1 && matrix[i][j + 1] > matrix[i][j]) { // Right
            maxPath = Math.max(maxPath, 1 + dfs(matrix, dp, i, j + 1));
        }
        dp[i][j] = maxPath; // Cache the result
        return maxPath;
    }
}
