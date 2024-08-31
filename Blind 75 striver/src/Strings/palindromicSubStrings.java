package Strings;

// LC 647 : Palindromic Substrings
// Given a string s, return the number of palindromic substrings in it.
// A string is a palindrome when it reads the same backward as forward.
// A substring is a contiguous sequence of characters within the string.
// Example 1:
// Input: s = "abc"
// Output: 3
// Explanation: Three palindromic strings: "a", "b", "c".
// Example 2:
// Input: s = "aaa"
// Output: 6
// Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".

public class palindromicSubStrings {
    public int countSubstrings(String s) { // time : O(n^2), space : O(1)
        int n = s.length();
        int count = 0;
        for(int i = 0; i < n; i++) {
            count += countPalindromes(s, i, i); // odd length
            count += countPalindromes(s, i, i + 1); // even length
        }
        return count;
    }

    private int countPalindromes(String s, int l, int r) {
        int count = 0;
        while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            count++;
            l--;
            r++;
        }
        return count;
    }
}
