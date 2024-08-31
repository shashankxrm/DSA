package Strings;

// LC 49 : Group Anagrams
// Given an array of strings strs, group the anagrams together. You can return the answer in any order.
// An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all
// the original letters exactly once.
// Example 1:
// Input: strs = ["eat","tea","tan","ate","nat","bat"]
// Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
// Example 2:
// Input: strs = [""]
// Output: [[""]]
// Example 3:
// Input: strs = ["a"]
// Output: [["a"]]
// Constraints:
// 1 <= strs.length <= 104

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;


public class groupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) { // time : O(n * m * logm), space : O(n * m) where n = strs.length, m = max(strs[i].length())
        Map<String, List<String>> map = new HashMap<>();
        for(String str : strs) {
            char[] arr = str.toCharArray();
            Arrays.sort(arr);
            String key = new String(arr);
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(str);
        }
        return new ArrayList<>(map.values());
    }
    // using frequency array
    public List<List<String>> groupAnagrams2(String[] strs) { // time : O(n * m), space : O(n * m) where n = strs.length, m = max(strs[i].length())
        Map<String, List<String>> map = new HashMap<>();
        for(String str : strs) {
            int[] freq = new int[26];
            for(char c : str.toCharArray()) {
                freq[c - 'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < 26; i++) {
                sb.append("#").append(freq[i]);
            }
            String key = sb.toString();
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(str);
        }
        return new ArrayList<>(map.values());
    }
}
