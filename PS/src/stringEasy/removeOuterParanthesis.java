package stringEasy;

// LC 1021 : https://leetcode.com/problems/remove-outermost-parentheses/
// A valid parentheses string is either empty "", "(" + A + ")", or A + B, where A and B are valid parentheses strings,
// and + represents string concatenation. For example, "", "()", "(())()", and "(()(()))" are all valid parentheses strings.
// A valid parentheses string S is primitive if it is nonempty, and there does not exist a way to split it into S = A+B,
// with A and B nonempty valid parentheses strings.
// Given a valid parentheses string S, consider its primitive decomposition: S = P_1 + P_2 + ... + P_k,
// where P_i are primitive valid parentheses strings.
// Return S after removing the outermost parentheses of every primitive string in the primitive decomposition of S.


public class removeOuterParanthesis {
    public String removeOuterParentheses(String s) {
        StringBuilder sb = new StringBuilder();
        int open = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                if (open > 0) {
                    sb.append(c);
                }
                open++;
            } else {
                open--;
                if (open > 0) {
                    sb.append(c);
                }
            }
        }
        return sb.toString();
    }
}
