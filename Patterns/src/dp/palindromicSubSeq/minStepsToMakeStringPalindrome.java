package dp.palindromicSubSeq;
// LC1278: Palindrome Partitioning III
// Given a string s and an integer k, partition s into k palindromic substrings such that the sum of the lengths of the
// palindromic substrings is maximized. Return the maximum sum of lengths of the palindromic substrings.
// Example: Input: s = "ababa", k = 2 Output: 5 (The optimal partition is "aba" and "ba", both are palindromes)
public class minStepsToMakeStringPalindrome {
    public int palindromePartition(String s, int k) { // Time: O(n^3), Space: O(n^2)
        int n = s.length();
        int[][] dp = new int[n][n]; // DP array to store the minimum cuts for palindromic partitions
        boolean[][] isPalindrome = new boolean[n][n]; // Array to check if a substring is a palindrome
        // Fill the isPalindrome array
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (s.charAt(i) == s.charAt(j) && (j - i <= 2 || isPalindrome[i + 1][j - 1])) {
                    isPalindrome[i][j] = true; // Mark substring as palindrome
                }
            }
        }
        // Fill the dp array for minimum cuts
        for (int i = 0; i < n; i++) {
            dp[i][0] = isPalindrome[0][i] ? 0 : Integer.MAX_VALUE; // Base case for single partition
            for (int j = 1; j <= k; j++) {
                dp[i][j] = Integer.MAX_VALUE;
                for (int p = 0; p <= i; p++) {
                    if (isPalindrome[p][i]) {
                        dp[i][j] = Math.min(dp[i][j], dp[p - 1][j - 1] + (i - p + 1)); // Update minimum cuts
                    }
                }
            }
        }
        return dp[n - 1][k]; // Return the maximum sum of lengths of palindromic substrings
    }
}
