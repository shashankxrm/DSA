package Strings;

// LC 76 : Minimum Window Substring
// Given two strings s and t of lengths m and n respectively, return the minimum window substring of s such that every
// character in t (including duplicates) is included in the window. If there is no such substring, return the empty string "".
// The testcases will be generated such that the answer is unique.
// A substring is a contiguous sequence of characters within the string.
// Example 1:
// Input: s = "ADOBECODEBANC", t = "ABC"
// Output: "BANC"
// Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.
// Example 2:
// Input: s = "a", t = "a"
// Output: "a"
// Explanation: The entire string s is the minimum window.
// Example 3:
// Input: s = "a", t = "aa"
// Output: ""
// Explanation: Both 'a's from t must be included in the window.

public class minimumWindowSubString {
    public String minWindow(String s, String t) { // time : O(n), space : O(1)
        int n = s.length();
        int m = t.length();
        if(n < m) return "";
        int[] freq = new int[128];
        for(char c : t.toCharArray()) {
            freq[c]++;
        }
        int i = 0, j = 0, minLen = Integer.MAX_VALUE, minStart = 0, count = m;
        while(j < n) {
            if(freq[s.charAt(j)] > 0) {
                count--;
            }
            freq[s.charAt(j)]--;
            while(count == 0) {
                if(j - i + 1 < minLen) {
                    minLen = j - i + 1;
                    minStart = i;
                }
                freq[s.charAt(i)]++;
                if(freq[s.charAt(i)] > 0) {
                    count++;
                }
                i++;
            }
            j++;
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
    }
}
