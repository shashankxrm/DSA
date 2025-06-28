package stack;

// LC739: Daily Temperatures
// Given an array of integers temperatures represents the daily temperatures, return an array answer such that answer[i]
// is the number of days you have to wait after the ith day to get a warmer temperature. If there is no future day for which
// this is possible, keep answer[i] == 0 instead.
// Example 1: Input: temperatures = [73,74,75,71,69,72,76,73] Output: [1,1,4,2,1,1,0,0]
// Example 2: Input: temperatures = [30,40,50,60] Output: [1,1,1,0]
public class dailyTemp {
    public int[] dailyTemperatures(int[] temperatures) { // Time: O(n), Space: O(n)
        int n = temperatures.length;
        int[] answer = new int[n];
        java.util.Stack<Integer> stack = new java.util.Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int idx = stack.pop();
                answer[idx] = i - idx; // Calculate the number of days to wait
            }
            stack.push(i); // Push current index onto the stack
        }
        return answer; // Remaining indices in stack will have answer[i] == 0
    }
}
