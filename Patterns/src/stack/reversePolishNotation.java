package stack;

// LC150: Evaluate Reverse Polish Notation
// Evaluate the value of an arithmetic expression in Reverse Polish Notation (RPN).
// Valid operators are +, -, *, and /. Each operand may be an integer or another expression.
// Example 1: Input: tokens = ["2","1","+","3","*"] Output: 9 Explanation: ((2 + 1) * 3) = 9
// Example 2: Input: tokens = ["4","13","5","/","+"] Output: 6 Explanation: (4 + (13 / 5)) = 6
public class reversePolishNotation {
    public int evalRPN(String[] tokens) { // Time: O(n), Space: O(n)
        java.util.Stack<Integer> stack = new java.util.Stack<>();
        for (String token : tokens) {
            if (token.equals("+")) {
                int b = stack.pop(); int a = stack.pop();
                stack.push(a + b);
            } else if (token.equals("-")) {
                int b = stack.pop(); int a = stack.pop();
                stack.push(a - b);
            } else if (token.equals("*")) {
                int b = stack.pop(); int a = stack.pop();
                stack.push(a * b);
            } else if (token.equals("/")) {
                int b = stack.pop(); int a = stack.pop();
                stack.push(a / b);
            } else {
                stack.push(Integer.parseInt(token)); // Push number onto the stack
            }
        }
        return stack.pop(); // The result will be the only element left in the stack
    }
}
