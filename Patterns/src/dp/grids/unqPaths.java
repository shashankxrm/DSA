package dp.grids;
// LC62: Unique Paths
// A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
// The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner
// of the grid (marked 'Finish' in the diagram below).
// How many possible unique paths are there?
// Example: Input: m = 3, n = 7 Output: 28 (There are 28 unique paths from the top-left to the bottom-right corner)
public class unqPaths {
    public int uniquePaths(int m, int n) { // Time: O(m*n), Space: O(n)
        int[] dp = new int[n]; // DP array to store the number of unique paths
        for (int i = 0; i < n; i++) {
            dp[i] = 1; // Initialize the first row with 1s
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[j] += dp[j - 1]; // Update the DP array based on previous values
            }
        }
        return dp[n - 1]; // Return the number of unique paths to the bottom-right corner
    }
}
