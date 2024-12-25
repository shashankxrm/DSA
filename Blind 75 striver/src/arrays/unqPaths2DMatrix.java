package arrays;

// LC 62 : Unique Paths
// A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
// The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right
// corner of the grid (marked 'Finish' in the diagram below).
// How many possible unique paths are there?
// Example 1:
// Input: m = 3, n = 7
// Output: 28
// Example 2:
// Input: m = 3, n = 2
// Output: 3

public class unqPaths2DMatrix {
    static int uniquePaths(int m, int n) { // O(m*n) time and O(m*n) space
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {  // Fill the first column with 1
            dp[i][0] = 1;
        }
        for (int i = 0; i < n; i++) { // Fill the first row with 1
            dp[0][i] = 1;
        }
        for (int i = 1; i < m; i++) { // Fill the rest of the matrix with sum of top and left elements
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1]; // Return the last element
    }

    public static void main(String[] args) {
        int m = 3;
        int n = 7;
        System.out.println(uniquePaths(m, n));
    }
}
