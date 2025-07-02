package dp.grids;
// LC64: Minimum Path Sum
// Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right,
// which minimizes the sum of all numbers along its path. Note: You can only move either down or right at any point in time.
// Example: Input: grid = [[1,3,1],[1,5,1],[4,2,1]] Output: 7 (Path: 1 -> 3 -> 1 -> 1 -> 1)
public class minPathSum {
    public int minPathSum(int[][] grid) { // Time: O(m*n), Space: O(n)
        int m = grid.length, n = grid[0].length;
        int[] dp = new int[n]; // DP array to store the minimum path sums
        dp[0] = grid[0][0]; // Start with the top-left corner
        // Initialize the first row
        for (int j = 1; j < n; j++) {
            dp[j] = dp[j - 1] + grid[0][j];
        }
        // Fill the DP array for the rest of the grid
        for (int i = 1; i < m; i++) {
            dp[0] += grid[i][0]; // First column
            for (int j = 1; j < n; j++) {
                dp[j] = Math.min(dp[j], dp[j - 1]) + grid[i][j]; // Update DP array with minimum path sum
            }
        }
        return dp[n - 1]; // Return the minimum path sum to the bottom-right corner
    }
}
