package Strings;

public class LongestPalindromeSubString {
    public String longestPalindrome(String s) { // time : O(n^2), space : O(1)
        if(s == null || s.length() < 1) return "";
        int start = 0, end = 0;
        for(int i = 0; i < s.length(); i++) {
            int len1 = expandFromMiddle(s, i, i);
            int len2 = expandFromMiddle(s, i, i+1);
            int len = Math.max(len1, len2);
            if(len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end+1);
    }
    public int expandFromMiddle(String s, int left, int right) {
        if(s == null || left > right) return 0;
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }
    // time complexity of O(n)
    public String longestPalindrome2(String s) {
        if(s == null || s.length() < 1) return "";
        int start = 0, end = 0;
        for(int i = 0; i < s.length(); i++) {
            int len1 = expandFromMiddle2(s, i, i);
            int len2 = expandFromMiddle2(s, i, i+1);
            int len = Math.max(len1, len2);
            if(len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end+1);
    }
    public int expandFromMiddle2(String s, int left, int right) {
        if(s == null || left > right) return 0;
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }
    // time complexity of O(1)
    public String longestPalindromemain(String s) {
        if(s == null || s.length() < 1) return "";
        int start = 0, end = 0;
        for(int i = 0; i < s.length(); i++) {
            int len1 = expandFromMiddle3(s, i, i);
            int len2 = expandFromMiddle3(s, i, i+1);
            int len = Math.max(len1, len2);
            if(len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end+1);
    }
    public int expandFromMiddle3(String s, int left, int right) {
        if(s == null || left > right) return 0;
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }
}
