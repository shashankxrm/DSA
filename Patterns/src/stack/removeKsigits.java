package stack;

// LC402: Remove K Digits
// Given a string num representing a non-negative integer and an integer k, return the smallest possible integer after
// removing k digits from num.
// Example 1: Input: num = "1432219", k = 3 Output: "1219"
// Example 2: Input: num = "10200", k = 1 Output: "200"
public class removeKsigits {
    public String removeKdigits(String num, int k) { // Time: O(n), Space: O(n)
        if (k >= num.length()) return "0"; // If k is greater than or equal to the length of num, return "0"
        java.util.Stack<Character> stack = new java.util.Stack<>();
        for (char c : num.toCharArray()) {
            while (k > 0 && !stack.isEmpty() && stack.peek() > c) {
                stack.pop(); // Remove the top element if it's greater than the current character
                k--; // Decrease k
            }
            stack.push(c); // Push the current character onto the stack
        }
        // If there are still digits to remove, remove from the end
        while (k > 0 && !stack.isEmpty()) {
            stack.pop();
            k--;
        }
        // Build the result from the stack
        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }
        // Reverse the result and remove leading zeros
        result.reverse();
        while (result.length() > 1 && result.charAt(0) == '0') {
            result.deleteCharAt(0); // Remove leading zeros
        }
        return result.length() == 0 ? "0" : result.toString(); // Return "0" if the result is empty
    }
}
