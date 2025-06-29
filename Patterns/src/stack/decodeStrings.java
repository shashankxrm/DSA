package stack;

// LC394: Decode String
// Given an encoded string, return its decoded string.
// The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated
// exactly k times. You may assume that the input string is always valid; no extra white spaces, square brackets are
// well-formed, and k is a positive integer.
// Example 1: Input: s = "3[a]2[bc]" Output: "aaabcbc"
// Example 2: Input: s = "3[a2[c]]" Output: "accaccacc"
public class decodeStrings {
    public String decodeString(String s) { // Time: O(n), Space: O(n)
        java.util.Stack<Integer> countStack = new java.util.Stack<>();
        java.util.Stack<StringBuilder> stringStack = new java.util.Stack<>();
        StringBuilder currentString = new StringBuilder();
        int k = 0;
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                k = k * 10 + (c - '0'); // Build the multiplier k
            } else if (c == '[') {
                countStack.push(k); // Push the current k onto the stack
                stringStack.push(currentString); // Push the current string onto the stack
                currentString = new StringBuilder(); // Reset current string
                k = 0; // Reset k for the next segment
            } else if (c == ']') {
                StringBuilder temp = currentString;
                currentString = stringStack.pop(); // Pop the last string from the stack
                int repeatCount = countStack.pop(); // Pop the last k from the stack
                for (int i = 0; i < repeatCount; i++) {
                    currentString.append(temp); // Append the repeated segment
                }
            } else {
                currentString.append(c); // Append regular characters to the current string
            }
        }
        return currentString.toString(); // Return the final decoded string
    }
}
