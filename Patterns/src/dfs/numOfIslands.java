package dfs;

// LC200: Number of Islands
// Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.
// An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume
// all four edges of the grid are all surrounded by water.
// Example 1: Input: grid = [["1","1","1","1","0"],["1","1","0","1","0"],["1","1","0","0","0"],["0","0","0","0","0"]]
// Output: 1 Explanation: There is one island in the grid.
public class numOfIslands {
    public int numIslands(char[][] grid) { // Time: O(m * n), Space: O(m * n)
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int m = grid.length, n = grid[0].length, count = 0;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    dfs(grid, visited, i, j);
                    count++;
                }
            }
        }
        return count;
    }
    private void dfs(char[][] grid, boolean[][] visited, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || visited[i][j] || grid[i][j] == '0') return;
        visited[i][j] = true;
        dfs(grid, visited, i - 1, j); // up
        dfs(grid, visited, i + 1, j); // down
        dfs(grid, visited, i, j - 1); // left
        dfs(grid, visited, i, j + 1); // right
    }
}
