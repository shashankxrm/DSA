package slidingWindow;
import java.util.*;



// LC438: Find All Anagrams in a String
// Given two strings s and p, return an array of all the start indices of p's anagrams in s.
// Example 1: Input: s = "cbaebabacd", p = "abc" Output: [0, 6]
// Explanation: The substring with start index = 0 is "cba", which is an anagram of "abc". The substring with start
// index = 6 is "bac", which is an anagram of "abc".

public class allAnagramsInAstring {
    public List<Integer> findAnagrams(String s, String p) { // Time: O(n), Space: O(1)
        List<Integer> result = new ArrayList<>();
        if (s.length() < p.length()) return result; // If s is shorter than p, no anagrams can exist
        int[] pFreq = new int[26]; // Frequency array for characters in p
        int[] sFreq = new int[26]; // Frequency array for the current window in s
        // Fill frequency array for p
        for (char c : p.toCharArray()) {
            pFreq[c - 'a']++;
        }
        // Sliding window over s
        for (int i = 0; i < s.length(); i++) {
            sFreq[s.charAt(i) - 'a']++; // Add current character to the window
            // Remove the character that is left out of the window
            if (i >= p.length()) {
                sFreq[s.charAt(i - p.length()) - 'a']--;
            }
            // Compare frequency arrays
            if (i >= p.length() - 1 && matches(pFreq, sFreq)) {
                result.add(i - p.length() + 1); // Start index of the anagram
            }
        }
        return result;
    }
    private boolean matches(int[] pFreq, int[] sFreq) {
        for (int i = 0; i < 26; i++) {
            if (pFreq[i] != sFreq[i]) {
                return false; // If any character frequency does not match, return false
            }
        }
        return true; // All character frequencies match
    }
}
