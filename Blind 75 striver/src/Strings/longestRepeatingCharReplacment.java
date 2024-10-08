package Strings;

// LC 424 : Longest Repeating Character Replacement
// Given a string s that consists of only uppercase English letters, you can perform at most k operations on that string.
// In one operation, you can choose any character of the string and change it to any other uppercase English character.
// Find the length of the longest sub-string containing all repeating letters you can get after performing the above operations.
// Note:
// Both the string's length and k will not exceed 104.
// Example 1:
// Input: s = "ABAB", k = 2
// Output: 4
// Explanation: Replace the two 'A's with two 'B's or vice versa.
// Example 2:
// Input: s = "AABABBA", k = 1
// Output: 4
// Explanation: Replace the one 'A' in the middle with 'B' and form "AABBBBA".
// The substring "BBBB" has the longest repeating letters, which is 4.

public class longestRepeatingCharReplacment {
    public int characterReplacement(String s, int k) { // time : O(n), space : O(1)
        int n = s.length();
        int[] freq = new int[26];
        int i = 0, j = 0, maxLen = 0, maxFreq = 0;
        while(j < n) {
            freq[s.charAt(j) - 'A']++;
            maxFreq = Math.max(maxFreq, freq[s.charAt(j) - 'A']);
            if(j - i + 1 - maxFreq > k) {
                freq[s.charAt(i) - 'A']--;
                i++;
            }
            maxLen = Math.max(maxLen, j - i + 1);
            j++;
        }
        return maxLen;
    }


}
