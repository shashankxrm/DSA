package stringEasy;

// LC 242 : https://leetcode.com/problems/valid-anagram/
// Given two strings s and t, return true if t is an anagram of s, and false otherwise.
// An anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
// typically using all the original letters exactly once.
// ex: s = "anagram", t = "nagaram" => true
// ex: s = "rat", t = "car" => false

import java.util.Arrays;

public class validAnagram {
    static boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        char[] arr1 = s.toCharArray();
        Arrays.sort(arr1);
        char[] arr2 = t.toCharArray();
        Arrays.sort(arr2);
        return Arrays.equals(arr1, arr2);
    }

    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagarms";
        System.out.println(isAnagram(s, t));
    }
}
