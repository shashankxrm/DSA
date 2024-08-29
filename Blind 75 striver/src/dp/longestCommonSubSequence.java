package dp;

// LC 1143 : Longest Common Subsequence
// Given two strings text1 and text2, return the length of their longest common subsequence.
// A subsequence of a string is a new string generated from the original string with some characters(can be none) deleted
// without changing the relative order of the remaining characters. (eg, "ace" is a subsequence of "abcde" while "aec" is not).
// A common subsequence of two strings is a subsequence that is common to both strings.
// If there is no common subsequence, return 0.
// Example 1:
// Input: text1 = "abcde", text2 = "ace"
// Output: 3
// Input: text1 = "abc", text2 = "def"
// Output: 0
// Input: text1 = "abc", text2 = "abc"
// Output: 3

public class longestCommonSubSequence {
    public static void main(String[] args) {
        String text1 = "abcde";
        String text2 = "ace";
        System.out.println(longestCommonSubsequence(text1, text2));
    }

    static int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length(), m = text2.length();
        char[] large, small;
        if (n > m) {
            large = text1.toCharArray();
            small = text2.toCharArray();
        } else {
            large = text2.toCharArray();
            small = text1.toCharArray();
            //swap lengths to store larger length in 'n'
            n = n ^ m;
            m = n ^ m;
            n = n ^ m;
        }
        int[] dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            int prev = dp[0]; // store the value before updating dp[j]
            for (int j = 1; j <= m; j++) {
                int temp = dp[j]; // store the current value of dp[j]
                if (large[i - 1] == small[j - 1]) {
                    dp[j] = prev + 1;
                } else {
                    dp[j] = Math.max(dp[j], dp[j - 1]);
                }
                prev = temp; // update prev for the next iteration
            }
        }
        return dp[m];
    }

}
