package Strings;

// LC 20 : Valid Parentheses
// Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
// An input string is valid if:
// Open brackets must be closed by the same type of brackets.
// Open brackets must be closed in the correct order.
// Example 1:
// Input: s = "()"
// Output: true
// Example 2:
// Input: s = "()[]{}"
// Output: true
// Example 3:
// Input: s = "(]"
// Output: false
// Example 4:
// Input: s = "([)]"
// Output: false

import java.util.Stack;

public class validParanthesis {
    public boolean isValid(String s) { // time : O(n), space : O(n)
        if(s.length() % 2 != 0) return false;
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()) {
            if(c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if(stack.isEmpty()) return false;
                char top = stack.pop();
                if(c == ')' && top != '(') return false;
                if(c == '}' && top != '{') return false;
                if(c == ']' && top != '[') return false;
            }
        }
        return stack.isEmpty();
    }
    // constant space
    public boolean isValid2(String s) { // time : O(n), space : O(1)
        if(s.length() % 2 != 0) return false;
        int n = s.length();
        int index = 0;
        char[] stack = new char[n];
        for(char c : s.toCharArray()) {
            if(c == '(' || c == '{' || c == '[') {
                stack[index++] = c;
            } else {
                if(index == 0) return false;
                char top = stack[--index];
                if(c == ')' && top != '(') return false;
                if(c == '}' && top != '{') return false;
                if(c == ']' && top != '[') return false;
            }
        }
        return index == 0;
    }
}
