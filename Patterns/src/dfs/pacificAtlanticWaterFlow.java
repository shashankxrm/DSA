package dfs;
import java.util.*;

// LC417: Pacific Atlantic Water Flow
// Given an m x n matrix of non-negative integers representing the height of each unit cell in a continent,
// the "Pacific Ocean" touches the left and top edges of the matrix and the "Atlantic Ocean" touches the right and bottom edges.
// Water can only flow in four directions (up, down, left, right) from a cell to another one with an equal or lower height.
// Find the list of grid coordinates where water can flow to both the Pacific and Atlantic oceans.
// Example 1: Input: heights = [[1,2,2,3,5],[3,2,3,4,4],[2,4,5,3,1],[6,7,1,4,5],[5,1,1,2,4]]
// // Output: [[0,4],[1,3],[2,2],[3,1],[4,0]]
public class pacificAtlanticWaterFlow {
    public List<List<Integer>> pacificAtlantic(int[][] heights) { // Time: O(m * n), Space: O(m * n)
        if (heights == null || heights.length == 0 || heights[0].length == 0) return new ArrayList<>();
        int m = heights.length, n = heights[0].length;
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            dfs(heights, pacific, i, 0); // Pacific Ocean
            dfs(heights, atlantic, i, n - 1); // Atlantic Ocean
        }
        for (int j = 0; j < n; j++) {
            dfs(heights, pacific, 0, j); // Pacific Ocean
            dfs(heights, atlantic, m - 1, j); // Atlantic Ocean
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    result.add(Arrays.asList(i, j));
                }
            }
        }
        return result;
    }
    private void dfs(int[][] heights, boolean[][] visited, int i, int j) {
        if (i < 0 || i >= heights.length || j < 0 || j >= heights[0].length || visited[i][j]) return;
        visited[i][j] = true;
        int height = heights[i][j];
        if (i > 0 && heights[i - 1][j] >= height) dfs(heights, visited, i - 1, j); // up
        if (i < heights.length - 1 && heights[i + 1][j] >= height) dfs(heights, visited, i + 1, j); // down
        if (j > 0 && heights[i][j - 1] >= height) dfs(heights, visited, i, j - 1); // left
        if (j < heights[0].length - 1 && heights[i][j + 1] >= height) dfs(heights, visited, i, j + 1);// right
    }
}
