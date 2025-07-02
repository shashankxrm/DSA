package dp.longestCommonSubsequence;
// LC583: Delete Operation for Two Strings
// Given two strings word1 and word2, return the minimum number of steps required to make word1 and word2 the same.
// In one step, you can delete exactly one character in either string.
// Example: Input: word1 = "sea", word2 = "eat" Output: 2 (Steps: delete 's' from "sea" and 't' from "eat")
public class deleteOperationFor2Strings {
    public int minDistance(String word1, String word2) { // Time: O(m * n), Space: O(m * n)
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m + 1][n + 1]; // DP array to store lengths of common subsequences
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) { // If characters match
                    dp[i][j] = dp[i - 1][j - 1] + 1; // Increment the length of common subsequence
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]); // Take the maximum from previous computations
                }
            }
        }
        return m + n - 2 * dp[m][n]; // Return the minimum steps required
    }
}
