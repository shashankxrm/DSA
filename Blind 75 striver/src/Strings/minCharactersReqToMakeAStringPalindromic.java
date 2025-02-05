package Strings;

// Given a string A. The only operation allowed is to insert characters at the beginning of the string.
//Find how many minimum characters are needed to be inserted to make the string a palindrome string.
//Input Format:
//The only argument given is string A.
//Output Format:
//Return the minimum characters that are needed to be inserted to make the string a palindrome string.
//For Example
//Input 1:
//    A = "ABC"
//Output 1:
//    2
//    Explanation 1:
//        Insert 'B' at beginning, string becomes: "BABC".
//        Insert 'C' at beginning, string becomes: "CBABC".
//
//Input 2:
//    A = "
//Output 2:
//    0
//    Explanation 2:
//        The string is already a palindrome.

public class minCharactersReqToMakeAStringPalindromic {
    public int solve(String A) { // O(n) O(n)
        int n = A.length();
        String s = A + "$" + new StringBuilder(A).reverse().toString();
        int[] lps = new int[2 * n + 1];
        int len = 0;
        lps[0] = 0;
        int i = 1;
        while(i < 2 * n + 1){
            if(s.charAt(i) == s.charAt(len)){
                len++;
                lps[i] = len;
                i++;
            }else{
                if(len != 0){
                    len = lps[len - 1];
                }else{
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return n - lps[2 * n];
    }
}
