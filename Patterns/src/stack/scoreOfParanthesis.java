package stack;

// LC856: Score of Parentheses
// Given a balanced parentheses string s, compute the score of the string based on the following rules:
// - "()" has a score of 1. - "AB" has a score of A + B, where A and B are balanced parentheses strings.
// - "(A)" has a score of 2 * A, where A is a balanced parentheses string.
// Example 1: Input: s = "()" Output: 1
// Example 2: Input: s = "(())" Output: 2
public class scoreOfParanthesis {
    public int scoreOfParentheses(String s) { // Time: O(n), Space: O(n)
        java.util.Stack<Integer> stack = new java.util.Stack<>();
        int score = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(score); // Push current score onto the stack
                score = 0; // Reset score for the new level
            } else {
                score = stack.pop() + Math.max(2 * score, 1); // Calculate score for the current level
            }
        }
        return score; // Final score after processing all characters
    }
}
