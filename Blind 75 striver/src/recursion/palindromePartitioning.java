package recursion;

// LC 131 : Palindrome Partitioning
// Given a string s, partition s such that every substring of the partition is a palindrome. Return all possible
// palindrome partitioning of s.
// A palindrome string is a string that reads the same backward as forward.
// Example 1:
// Input: s = "aab"
// Output: [["a","a","b"],["aa","b"]]
// Example 2:
// Input: s = "a"
// Output: [["a"]]

import java.util.*;
public class palindromePartitioning {
    public List<List<String>> partition(String s) { // O(n * 2^n) O(n)
        List<List<String>> result = new ArrayList<>();
        helper(s, 0, new ArrayList<>(), result);
        return result;
    }

    private void helper(String s, int index, List<String> current, List<List<String>> result){
        if(index == s.length()){
            result.add(new ArrayList<>(current));
            return;
        }
        for(int i = index; i < s.length(); i++){
            if(isPalindrome(s, index, i)){
                current.add(s.substring(index, i + 1));
                helper(s, i + 1, current, result);
                current.remove(current.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s, int start, int end){
        while(start < end){
            if(s.charAt(start++) != s.charAt(end--)){
                return false;
            }
        }
        return true;
    }
}
