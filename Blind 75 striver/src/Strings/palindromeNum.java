package Strings;

// LC 9 : Palindrome Number
// Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.
// Follow up: Could you solve it without converting the integer to a string?
// Example 1:
// Input: x = 121
// Output: true
// Example 2:
// Input: x = -121
// Output: false

public class palindromeNum {
    public boolean isPalindrome(int x) {
        if(x < 0) return false;
        int num = x;
        int rev = 0;
        while(num > 0) {
            rev = rev * 10 + num % 10;
            num /= 10;
        }
        return rev == x;
    }
    // without converting to string
    public boolean isPalindrome2(int x) {
        if(x < 0) return false;
        int num = x;
        int rev = 0;
        while(num > 0) {
            if(rev > Integer.MAX_VALUE / 10) return false;
            rev = rev * 10 + num % 10;
            num /= 10;
        }
        return rev == x;
    }

}
