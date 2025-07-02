package dp.grids;
// LC329: Longest Increasing Path in a Matrix
// Given an m x n integers matrix, return the length of the longest increasing path in matrix.
// From each cell, you can move in four directions: left, right, up, or down.
// You may not move diagonally or move outside the boundary (i.e., wrap-around is not allowed).
// Example: Input: matrix = [[9,9,4],[6,6,8],[2,1,1]] Output: 4 (The longest increasing path is [1,2,6,9])
public class longestIncPathMatrix {
    public int longestIncreasingPath(int[][] matrix) { // Time: O(m*n), Space: O(m*n)
        if (matrix.length == 0 || matrix[0].length == 0) return 0; // Handle empty matrix
        int m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[m][n]; // DP array to store the lengths of increasing paths
        int maxLength = 0; // Variable to track the maximum length of increasing path

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                maxLength = Math.max(maxLength, dfs(matrix, dp, i, j)); // Update maxLength with the result of DFS
            }
        }
        return maxLength; // Return the maximum length of increasing path
    }
    private int dfs(int[][] matrix, int[][] dp, int i, int j) { // DFS function to explore paths
        if (dp[i][j] != 0) return dp[i][j]; // Return cached result if already computed
        int m = matrix.length, n = matrix[0].length;
        int[] directions = {-1, 0, 1, 0, -1}; // Directions for moving in the grid
        dp[i][j] = 1; // Initialize path length for current cell
        for (int d = 0; d < 4; d++) { // Explore all four directions
            int ni = i + directions[d], nj = j + directions[d + 1];
            if (ni >= 0 && ni < m && nj >= 0 && nj < n && matrix[ni][nj] > matrix[i][j]) {
                dp[i][j] = Math.max(dp[i][j], 1 + dfs(matrix, dp, ni, nj)); // Update path length if valid move
            }
        }
        return dp[i][j]; // Return the computed path length for current cell
    }
}
