package graphs;
// LC 417 : Pacific Atlantic Water Flow
// Given an m x n matrix of non-negative integers representing the height of each unit cell in a continent,
// the "Pacific ocean" touches the left and top edges of the matrix and the "Atlantic ocean" touches the right and
// bottom edges. Water can only flow in four directions (up, down, left, or right) from a cell to another one with height
// equal or lower. Find the list of grid coordinates where water can flow to both the Pacific and Atlantic ocean.
// Note:
// The order of returned grid coordinates does not matter.
// Both m and n are less than 150.
// Example:
// Given the following 5x5 matrix:
//   Pacific ~   ~   ~   ~   ~
//        ~  1   2   2   3  (5) *
//        ~  3   2   3  (4) (4) *
//        ~  2   4  (5)  3   1  *
//        ~ (6) (7)  1   4   5  *
//        ~ (5)  1   1   2   4  *
//           *   *   *   *   * Atlantic
// Return:
// [[0, 4], [1, 3], [1, 4], [2, 2], [3, 0], [3, 1], [4, 0]]
// (positions with parentheses in above matrix).
// Explanation:
// The first row and first column can flow to both the Pacific and Atlantic ocean.
// The second row can only flow to the Pacific ocean.
// The second last and last columns can flow to the Atlantic ocean.
// The third row can flow to both the Pacific and Atlantic ocean.
// The fourth row can only flow to the Atlantic ocean.
// The fifth row can only flow to the Atlantic ocean.
// Therefore, the answer is [[0, 4], [1, 3], [1, 4], [2, 2], [3, 0], [3, 1], [4, 0]].


import java.util.*;

public class pacificAtlanticWaterFlow {
    public List<List<Integer>> pacificAtlantic(int[][] heights) { // O(m*n) time and O(m*n) space
        int rows = heights.length, cols = heights[0].length;
        boolean[][] pac = new boolean[rows][cols];
        boolean[][] atl = new boolean[rows][cols];

        for (int col = 0; col< cols; col++){
            dfs(0, col, rows, cols, pac, heights[0][col], heights);
            dfs(rows-1, col,rows, cols, atl, heights[rows-1][col], heights);
        }
        for (int row = 0; row<rows; row++){
            dfs(row, 0,rows, cols, pac, heights[row][0], heights);
            dfs(row, cols-1,rows, cols, atl, heights[row][cols-1], heights);
        }
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++){
                if (pac[i][j] && atl[i][j])
                    result.add(Arrays.asList(i,j));
            }
        return result;
    }
    private void dfs(int row, int col, int rows, int cols, boolean[][] visited, int prevHeight, int[][] heights){
        if (row < 0 || row >= rows || col < 0 || col >= cols || visited[row][col] || prevHeight > heights[row][col])
            return;
        visited[row][col]= true;
        dfs(row+1, col, rows, cols, visited, heights[row][col], heights);
        dfs(row-1, col, rows, cols, visited, heights[row][col], heights);
        dfs(row, col+1, rows, cols, visited, heights[row][col], heights);
        dfs(row, col-1, rows, cols, visited, heights[row][col], heights);

    }
}
