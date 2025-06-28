package prefixSum;

// LC221: Maximal Square
// Given a 2D binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.
// Example 1: Input: matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
// Output: 4 Explanation: The largest square has a side length of 2, so its area is 2 * 2 = 4.
public class maximalSquare {
    public int maximalSquare(char[][] matrix) { // Time: O(m * n), Space: O(n)
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int m = matrix.length, n = matrix[0].length;
        int[] dp = new int[n + 1];
        int maxSide = 0, prev = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                int temp = dp[j]; // Store the previous value before updating
                if (matrix[i - 1][j - 1] == '1') {
                    dp[j] = Math.min(dp[j - 1], Math.min(dp[j], prev)) + 1;
                    maxSide = Math.max(maxSide, dp[j]);
                } else {
                    dp[j] = 0;
                }
                prev = temp; // Update prev to the current dp[j] before the next iteration
            }
        }
        return maxSide * maxSide; // Return the area of the largest square
    }
}
