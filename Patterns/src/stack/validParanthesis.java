package stack;

// LC20: Valid Parentheses
// Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
// An input string is valid if:
// 1. Open brackets must be closed by the same type of brackets.
// 2. Open brackets must be closed in the correct order.
// Example 1: Input: s = "()" Output: true
// Example 2: Input: s = "()[]{}" Output: true
public class validParanthesis {
    public boolean isValid(String s) { // Time: O(n), Space: O(n)
        if (s.length() % 2 != 0) return false; // Odd length cannot be valid
        java.util.Stack<Character> stack = new java.util.Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) return false; // No matching opening bracket
                char top = stack.pop();
                if ((c == ')' && top != '(') ||
                    (c == '}' && top != '{') ||
                    (c == ']' && top != '[')) {
                    return false; // Mismatched brackets
                }
            }
        }
        return stack.isEmpty(); // All brackets must be closed
    }
}
