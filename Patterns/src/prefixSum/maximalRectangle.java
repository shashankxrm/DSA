package prefixSum;

// LC85: Maximal Rectangle
// Given a rows x cols binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.
// Example 1: Input: matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
// Output: 6 Explanation: The largest rectangle has an area of 6 (3 rows by 2 columns).

public class maximalRectangle {
    public int maximalRectangle(char[][] matrix) { // Time: O(m * n), Space: O(n)
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int m = matrix.length, n = matrix[0].length;
        int[] heights = new int[n];
        int maxArea = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                heights[j] = (matrix[i][j] == '1') ? heights[j] + 1 : 0;
            }
            maxArea = Math.max(maxArea, largestRectangleArea(heights));
        }
        return maxArea;
    }
    private int largestRectangleArea(int[] heights) { // Helper function to calculate the largest rectangle area in a histogram
        int maxArea = 0;
        int[] stack = new int[heights.length + 1];
        int top = -1;

        for (int i = 0; i <= heights.length; i++) {
            while (top >= 0 && (i == heights.length || heights[i] < heights[stack[top]])) {
                int h = heights[stack[top--]];
                int w = (top == -1) ? i : i - stack[top] - 1;
                maxArea = Math.max(maxArea, h * w);
            }
            stack[++top] = i;
        }
        return maxArea;
    }
}
