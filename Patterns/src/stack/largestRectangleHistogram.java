package stack;

// LC84: Largest Rectangle in Histogram
// Given an array of integers heights representing the histogram's bar height where the width of each bar is 1, return
// the area of the largest rectangle that can be formed in the histogram.
// Example 1: Input: heights = [2,1,5,6,2,3] Output: 10
// Example 2: Input: heights = [2,4] Output: 4
public class largestRectangleHistogram {
    public int largestRectangleArea(int[] heights) { // Time: O(n), Space: O(n)
        int n = heights.length;
        java.util.Stack<Integer> stack = new java.util.Stack<>();
        int maxArea = 0;
        for (int i = 0; i <= n; i++) {
            int h = (i == n) ? 0 : heights[i]; // Use 0 height at the end
            while (!stack.isEmpty() && h < heights[stack.peek()]) {
                int height = heights[stack.pop()];
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                maxArea = Math.max(maxArea, height * width);
            }
            stack.push(i);
        }
        return maxArea; // Return the maximum area found
    }
}
