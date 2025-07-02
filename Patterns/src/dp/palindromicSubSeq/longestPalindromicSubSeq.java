package dp.palindromicSubSeq;
// LC516: Longest Palindromic Subsequence
// Given a string s, return the length of the longest palindromic subsequence in s.
// A subsequence is a sequence that can be derived from another sequence by deleting some elements without changing the
// order of the remaining elements. A palindromic subsequence is a subsequence that reads the same backward as forward.
// Example: Input: s = "bbbab" Output: 4 (The longest palindromic subsequence is "bbbb")
public class longestPalindromicSubSeq {
    public int longestPalindromeSubseq(String s) { // Time: O(n^2), Space: O(n^2)
        int n = s.length();
        int[][] dp = new int[n][n]; // DP array to store lengths of palindromic subsequences
        for (int i = n - 1; i >= 0; i--) {
            dp[i][i] = 1; // Each single character is a palindrome of length 1
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) { // If characters match
                    dp[i][j] = dp[i + 1][j - 1] + 2; // Include both characters in the palindrome
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]); // Take the maximum from previous computations
                }
            }
        }
        return dp[0][n - 1]; // Return the length of the longest palindromic subsequence
    }
}
