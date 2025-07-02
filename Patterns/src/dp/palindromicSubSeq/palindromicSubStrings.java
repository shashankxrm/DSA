package dp.palindromicSubSeq;
// LC647: Palindromic Substrings
// Given a string s, return the number of palindromic substrings in it. A string is a palindrome when it reads the same
// backward as forward. A substring is a contiguous sequence of characters within a string.
// Example: Input: s = "abc" Output: 3 (The palindromic substrings are "a", "b", "c")
public class palindromicSubStrings {
    public int countSubstrings(String s) { // Time: O(n^2), Space: O(1)
        int n = s.length();
        int count = 0; // Initialize count of palindromic substrings
        for (int i = 0; i < n; i++) {
            count += expandAroundCenter(s, i, i); // Count odd-length palindromes
            count += expandAroundCenter(s, i, i + 1); // Count even-length palindromes
        }
        return count; // Return the total count of palindromic substrings
    }
    private int expandAroundCenter(String s, int left, int right) { // Helper method to expand around center
        int count = 0;
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            count++; // Found a palindromic substring
            left--; // Expand to the left
            right++; // Expand to the right
        }
        return count; // Return the count of palindromic substrings found
    }
}
