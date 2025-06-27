package slidingWindow;

// LC567: Permutation in String
// Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise.
// In other words, return true if one of s1's permutations is the substring of s2.
// Example 1: Input: s1 = "ab", s2 = "eidbaooo" Output: true Explanation: s2 contains one permutation of s1 ("ba").
// Example 2: Input: s1 = "ab", s2 = "eidboaoo" Output: false
public class permutationInStr {
    public boolean checkInclusion(String s1, String s2) { // Time: O(n), Space: O(1)
        if (s1.length() > s2.length()) return false;
        int[] freq = new int[26];
        for (char c : s1.toCharArray()) {
            freq[c - 'a']++;
        }
        int left = 0, right = 0, count = s1.length();
        while (right < s2.length()) {
            if (freq[s2.charAt(right) - 'a'] > 0) {
                count--;
            }
            freq[s2.charAt(right) - 'a']--;
            right++;
            if (count == 0) return true;
            if (right - left == s1.length()) {
                if (freq[s2.charAt(left) - 'a'] >= 0) {
                    count++;
                }
                freq[s2.charAt(left) - 'a']++;
                left++;
            }
        }
        return false;
    }
}
