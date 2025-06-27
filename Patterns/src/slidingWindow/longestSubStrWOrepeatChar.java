package slidingWindow;

// LC3: Longest Substring Without Repeating Characters
// Given a string s, find the length of the longest substring without repeating characters.
// Example 1: Input: s = "abcabcbb" Output: 3 Explanation: The answer is "abc", with the length of 3.
public class longestSubStrWOrepeatChar {
    public int lengthOfLongestSubstring(String s) { // Time: O(n), Space: O(1)
        int n = s.length(); int[] freq = new int[128];
        int i = 0, j = 0, maxLen = 0;
        while(j < n) {
            if(freq[s.charAt(j)] == 0) {
                freq[s.charAt(j)]++;
                maxLen = Math.max(maxLen, j - i + 1);
                j++;
            } else {
                freq[s.charAt(i)]--;
                i++;
            }
        }
        return maxLen;
    }
}
