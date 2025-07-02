package backtracking;

import java.util.*;
// LC131: Palindrome Partitioning
// Given a string s, partition s such that every substring of the partition is a palindrome.
// Return all possible palindrome partitioning of s.
// Example: Input: s = "aab" Output: [["a","a","b"],["aa","b"]]
public class palindromePartitioning {
    public List<List<String>> partition(String s) { // Time: O(2^n * n), Space: O(n)
        List<List<String>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), s, 0);
        return result;
    }
    private void backtrack(List<List<String>> result, List<String> tempList, String s, int start) {
        if (start == s.length()) {
            result.add(new ArrayList<>(tempList)); // Add the current partition
            return;
        }
        for (int i = start; i < s.length(); i++) {
            if (isPalindrome(s, start, i)) { // Check if the substring is a palindrome
                tempList.add(s.substring(start, i + 1)); // Include the current palindrome substring
                backtrack(result, tempList, s, i + 1); // Recur to build the next level
                tempList.remove(tempList.size() - 1); // Backtrack to explore other partitions
            }
        }
    }
    private boolean isPalindrome(String s, int left, int right) { // Check if a substring is a palindrome
        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--)) return false;
        }
        return true;
    }
}
