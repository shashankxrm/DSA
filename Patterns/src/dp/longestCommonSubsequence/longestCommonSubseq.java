package dp.longestCommonSubsequence;
// LC1143: Longest Common Subsequence
// Given two strings text1 and text2, return the length of their longest common subsequence.
// A subsequence of a string is a new string generated from the original string with some characters (can be none)
// deleted without changing the relative order of the remaining characters.
// (i.e., "ace" is a subsequence of "abcde" while "aec" is not).
// A common subsequence of two strings is a subsequence that is common to both strings.
// Example: Input: text1 = "abcde", text2 = "ace" Output: 3 (The longest common subsequence is "ace")
public class longestCommonSubseq {
    public int longestCommonSubsequence(String text1, String text2) { // Time: O(m * n), Space: O(m * n)
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m + 1][n + 1]; // DP array to store lengths of common subsequences

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) { // If characters match
                    dp[i][j] = dp[i - 1][j - 1] + 1; // Increment the length of common subsequence
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]); // Take the maximum from previous computations
                }
            }
        }
        return dp[m][n]; // Return the length of the longest common subsequence
    }
}
