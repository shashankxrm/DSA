package slidingWindow;

// LC159: Longest Substring with At Most Two Distinct Characters
// Given a string s, return the length of the longest substring that contains at most two distinct characters.
// Example 1: Input: s = "eceba" Output: 3 Explanation: The longest substring is "ece" with length 3.
public class longestSubStrWithMax2DistinctChars {
    public int lengthOfLongestSubstringTwoDistinct(String s) { // Time: O(n), Space: O(1)
        int n = s.length();
        if (n < 3) return n; // If string length is less than 3, return its length
        int[] freq = new int[128]; // Frequency array for characters
        int left = 0, right = 0, maxLen = 0, distinctCount = 0;
        while (right < n) {
            if (freq[s.charAt(right)] == 0) {
                distinctCount++;
            }
            freq[s.charAt(right)]++;
            right++;
            while (distinctCount > 2) {
                freq[s.charAt(left)]--;
                if (freq[s.charAt(left)] == 0) {
                    distinctCount--;
                }
                left++;
            }

            maxLen = Math.max(maxLen, right - left);
        }
        return maxLen;
    }
}
