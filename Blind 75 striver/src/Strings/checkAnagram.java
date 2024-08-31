package Strings;

// LC 242 : Valid Anagram
// Given two strings s and t, return true if t is an anagram of s, and false otherwise.
// Example 1:
// Input: s = "anagram", t = "nagaram"
// Output: true
// Example 2:
// Input: s = "rat", t = "car"
// Output: false


public class checkAnagram {
    public boolean isAnagram(String s, String t) { // time : O(n), space : O(1)
        if(s.length() != t.length()) return false;
        int[] freq = new int[26];
        for(char c : s.toCharArray()) {
            freq[c - 'a']++;
        }
        for(char c : t.toCharArray()) {
            freq[c - 'a']--;
        }
        for(int i : freq) {
            if(i != 0) return false;
        }
        return true;
    }
}
