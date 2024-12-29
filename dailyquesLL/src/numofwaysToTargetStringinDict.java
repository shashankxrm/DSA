// LC 1639. Number of Ways to Form a Target String Given a Dictionary
// You are given a list of strings of the same length words and a string target.
// Your task is to form target using the given words under the following rules:
// target should be formed from left to right.
// To form the ith character (0-indexed) of target, you can choose the kth character of the jth string in
// words if target[i] = words[j][k].
// Once you use the kth character of the jth string of words, you can no longer use the xth
// character of any string
// words where x <= k. In other words, all characters to the left of or at index k become unusuable for
// every string.
// Repeat the process until you form the string target.
// Notice that you can use multiple characters from the same string in words provided the conditions above are met.
// Return the number of ways to form target from words. Since the answer may be too large, return it modulo 109 + 7.
// Example 1:
// Input: words = ["acca","bbbb","caca"], target = "aba"
// Output: 6
// Explanation: There are 6 ways to form target.
// "aba" -> index 0 ("acca"), index 1 ("bbbb"), index 2 ("caca")
// "aba" -> index 0 ("acca"), index 1 ("bbbb"), index 3 ("caca")
// "aba" -> index 0 ("acca"), index 2 ("bbbb"), index 2 ("caca")
// "aba" -> index 0 ("acca"), index 2 ("bbbb"), index 3 ("caca")
// "aba" -> index 1 ("acca"), index 2 ("bbbb"), index 2 ("caca")
// "aba" -> index 1 ("acca"), index 2 ("bbbb"), index 3 ("caca")
// Example 2:
// Input: words = ["abba","baab"], target = "bab"
// Output: 4
// Explanation: There are 4 ways to form target.
// "bab" -> index 0 ("baab"), index 1 ("baab"), index 2 ("abba")
// "bab" -> index 0 ("baab"), index 1 ("abba"), index 2 ("baab")
// "bab" -> index 0 ("abba"), index 1 ("baab"), index 2 ("baab")
// "bab" -> index 0 ("abba"), index 1 ("baab"), index 2 ("abba")



public class numofwaysToTargetStringinDict {
    public int numWays(String[] words, String target) { // Time: O(n * m), Space: O(n * m)
        int n = words[0].length();
        int m = target.length();
        int mod = 1000000007;
        long[][] dp = new long[m + 1][n + 1];
        int[][] count = new int[n][26];

        // Calculate frequency of each character in each column
        for (String word : words) {
            for (int i = 0; i < n; i++) {
                count[i][word.charAt(i) - 'a']++;
            }
        }

        // Base case: 1 way to form an empty target
        for (int i = 0; i <= n; i++) {
            dp[0][i] = 1;
        }

        // Fill DP table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = dp[i][j - 1]; // Skip column
                char targetChar = target.charAt(i - 1);
                dp[i][j] = (dp[i][j] + dp[i - 1][j - 1] * count[j - 1][targetChar - 'a']) % mod;
            }
        }

        return (int) dp[m][n];
    }

}
