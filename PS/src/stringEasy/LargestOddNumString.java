package stringEasy;

// LC 1903 : https://leetcode.com/problems/largest-odd-number-in-string/
// You are given a string num, representing a large integer. Return the largest-valued odd integer (as a string)
//  that is a non-empty substring of num,
// or an empty string "" if no odd integer exists. A substring is a contiguous sequence of characters within a string.


public class LargestOddNumString {
    public String largestOddNumber(String num) {
        int n = num.length();
        for (int i = n - 1; i >= 0; i--) {
            if ((num.charAt(i) - '0') % 2 != 0) {
                return num.substring(0, i + 1);
            }
        }
        return "";
    }
}
