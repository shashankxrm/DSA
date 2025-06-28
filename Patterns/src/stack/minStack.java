package stack;
import java.util.*;

// LC155: Min Stack
// Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
// Implement the minStack class:
// - minStack() initializes the stack object.
// - void push(int val) pushes the element val onto the stack.
// - void pop() removes the element on the top of the stack.
// - int top() gets the top element of the stack.
// - int getMin() retrieves the minimum element in the stack.
public class minStack {
    private Stack<Integer> stack;
    private Stack<Integer> minStack;
    public minStack() { // Time: O(1), Space: O(n)
        stack = new Stack<>();
        minStack = new Stack<>();
    }
    public void push(int val) { // Time: O(1)
        stack.push(val);
        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        }
    }
    public void pop() { // Time: O(1)
        if (stack.isEmpty()) return;
        int popped = stack.pop();
        if (popped == minStack.peek()) {
            minStack.pop();
        }
    }
    public int top() { // Time: O(1)
        return stack.peek();
    }
    public int getMin() { // Time: O(1)
        return minStack.peek();
    }
}
