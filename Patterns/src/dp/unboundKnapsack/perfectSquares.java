package dp.unboundKnapsack;
// LC279: Perfect Squares
// Given an integer n, return the least number of perfect square numbers that sum to n.
// A perfect square is an integer that is the square of an integer; in other words, it is the product of some integer with itself.
// For example, 1, 4, 9, and 16 are perfect squares while 3 and 11 are not.
// Example: Input: n = 12 Output: 3 (12 = 4 + 4 + 4)
public class perfectSquares {
    public int numSquares(int n) { // Time: O(n * sqrt(n)), Space: O(n)
        int[] dp = new int[n + 1]; // DP array to store the least number of perfect squares for each number
        for (int i = 1; i <= n; i++) {
            dp[i] = Integer.MAX_VALUE; // Initialize with a large value
            for (int j = 1; j * j <= i; j++) { // Check all perfect squares less than or equal to i
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1); // Update the DP array
            }
        }
        return dp[n]; // Return the least number of perfect squares that sum to n
    }
}
