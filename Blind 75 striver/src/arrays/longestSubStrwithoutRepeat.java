package arrays;

// LC 3 : Longest Substring Without Repeating Characters
// Given a string s, find the length of the longest substring without repeating characters.
// Example 1:
// Input: s = "abcabcbb"
// Output: 3
// Explanation: The answer is "abc", with the length of 3.

import java.util.HashMap;
import java.util.Map;

public class longestSubStrwithoutRepeat {
    public int lengthOfLongestSubstring(String s) { // O(n) time and O(1) space but faster.
        int n = s.length();
        int[] lastIndex = new int[256];
        int i = 0, j = 0;
        int maxLen = 0;
        while (j < n) {
            if (lastIndex[s.charAt(j)] == 0) {
                lastIndex[s.charAt(j)] = 1;
                maxLen = Math.max(maxLen, j - i + 1);
                j++;
            } else {
                lastIndex[s.charAt(i)] = 0;
                i++;
            }
        }
        return maxLen;
    }
    public int lengthOfLongestSubstring2(String s) { // O(n) time and O(1) space
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

    public static void main(String[] args) {
        longestSubStrwithoutRepeat obj = new longestSubStrwithoutRepeat();
        String s = "abcabcbb";
        System.out.println(obj.lengthOfLongestSubstring(s));
    }
}
