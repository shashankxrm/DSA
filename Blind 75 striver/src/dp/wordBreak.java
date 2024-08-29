package dp;

// LC 139 : Word Break
// Given a string s and a dictionary of strings wordDict, return true if s can be segmented into a space-separated
// sequence of one or more dictionary words.
// Note that the same word in the dictionary may be reused multiple times in the segmentation.
// Example 1:
// Input: s = "leetcode", wordDict = ["leet","code"]
// Output: true
// Input: s = "applepenapple", wordDict = ["apple","pen"]
// Output: true
// Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
// Output: false
// Input: s = "cars", wordDict = ["car","ca","rs"]
// Output: true

import java.util.List;

public class wordBreak {

        public boolean wordBreak(String s, List<String> wordDict) {
            int n = s.length();
            boolean[] dp = new boolean[n + 1];
            dp[0] = true;
            int max_len = 0;
            for (String word : wordDict) {
                max_len = Math.max(max_len, word.length());
            }

            for (int i = 1; i <= n; i++) {
                for (int j = i - 1; j >= Math.max(i - max_len - 1, 0); j--) {
                    if (dp[j] && wordDict.contains(s.substring(j, i))) {
                        dp[i] = true;
                        break;
                    }
                }
            }

            return dp[n];
        }
    public static void main(String[] args) {
        wordBreak obj = new wordBreak();
        String s = "leetcode";
        List<String> wordDict = List.of("leet", "code");
        System.out.println(obj.wordBreak(s, wordDict));
    }
}
