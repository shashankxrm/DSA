package Strings;

// LC 3 : Longest Substring Without Repeating Characters
// Given a string s, find the length of the longest substring without repeating characters.
// Example 1:
// Input: s = "abcabcbb"
// Output: 3
// Explanation: The answer is "abc", with the length of 3.
// Example 2:
// Input: s = "bbbbb"
// Output: 1
// Explanation: The answer is "b", with the length of 1.

import java.util.HashMap;
import java.util.Map;

public class longestSunstringWoutRepeatChar {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int[] freq = new int[128];
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
    // using hashmap
    public int lengthOfLongestSubstring2(String s) {
        int n = s.length();
        int i = 0, j = 0, maxLen = 0;
        Map<Character, Integer> map = new HashMap<>();
        while(j < n) {
            if(map.containsKey(s.charAt(j))) {
                i = Math.max(i, map.get(s.charAt(j)) + 1);
            }
            map.put(s.charAt(j), j);
            maxLen = Math.max(maxLen, j - i + 1);
            j++;
        }
        return maxLen;
    }

}
