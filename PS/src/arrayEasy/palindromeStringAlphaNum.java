package arrayEasy;
// LC 125 : https://leetcode.com/problems/valid-palindrome/description/
// A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters,
// it reads the same forward and backward. Alphanumeric characters include letters and numbers.
//Given a string s, return true if it is a palindrome, or false otherwise.

public class palindromeStringAlphaNum {


    public boolean isPalindrome(String s) {
        s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        return validate(s);

    }
    static boolean validate(String s){
        for (int i = 0; i < s.length() / 2; i++){
            if(s.charAt(i) == s.charAt(s.length() - i - 1)){
                continue;
            } else {
                return false;
            }
        }
        return true;
    }
    public boolean isPalindrome2(String s) {  // optimised
        if (s.isEmpty()) {
            return true;
        }
        int start = 0;
        int last = s.length() - 1;
        while(start <= last) {
            char currFirst = s.charAt(start);
            char currLast = s.charAt(last);
            if (!Character.isLetterOrDigit(currFirst )) {
                start++;
            } else if(!Character.isLetterOrDigit(currLast)) {
                last--;
            } else {
                if (Character.toLowerCase(currFirst) != Character.toLowerCase(currLast)) {
                    return false;
                }
                start++;
                last--;
            }
        }
        return true;
    }
}




