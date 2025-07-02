package dp.longestCommonSubsequence;
// LC1092: Shortest Common Supersequence
// Given two strings str1 and str2, return the shortest string that has both str1 and str2 as subsequences.
// If multiple answers exist, you may return any of them.
// Example: Input: str1 = "abac", str2 = "cab" Output: "cabac" (Both "abac" and "cab" are subsequences of "cabac")
public class shortestCommonSuperSeq {
    public String shortestCommonSupersequence(String str1, String str2) { // Time: O(m * n), Space: O(m * n)
        int m = str1.length();
        int n = str2.length();
        int[][] dp = new int[m + 1][n + 1]; // DP array to store lengths of common subsequences
        // Fill the DP table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) { // If characters match
                    dp[i][j] = dp[i - 1][j - 1] + 1; // Increment the length of common subsequence
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]); // Take the maximum from previous computations
                }
            }
        }
        // Reconstruct the shortest common supersequence
        StringBuilder sb = new StringBuilder();
        int i = m, j = n;
        while (i > 0 && j > 0) {
            if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                sb.append(str1.charAt(i - 1)); // Append matching character
                i--;
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                sb.append(str1.charAt(i - 1)); // Append character from str1
                i--;
            } else {
                sb.append(str2.charAt(j - 1)); // Append character from str2
                j--;
            }
        }
        // Append remaining characters from str1 or str2
        while (i > 0) sb.append(str1.charAt(i--));
        while (j > 0) sb.append(str2.charAt(j--));
        return sb.reverse().toString(); // Return the constructed supersequence in reverse order
    }
}
