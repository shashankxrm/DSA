// LC 200. Number of Islands
// Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water),
// return the number of islands.
// An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
// You may assume all four edges of the grid are all surrounded by water.
// ex1 : Input: grid = [
//     ["1","1","1","1","0"],
//     ["1","1","0","1","0"],
//     ["1","1","0","0","0"],
//     ["0","0","0","0","0"]
// ]
// Output: 1
// ex2 : Input: grid = [
//     ["1","1","0","0","0"],
//     ["1","1","0","0","0"],
//     ["0","0","1","0","0"],
//     ["0","0","0","1","1"]
// ]
// Output: 3
public class numOfislands {
    public int numIslands(char[][] grid) { // time: O(m*n), space: O(m*n)
        int count = 0;
        int m = grid.length;
        int n = grid[0].length;
        boolean [][]visited = new boolean[m][n];
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(grid[i][j] == '1' && !visited[i][j]) {
                    visit(i, j, grid, visited);
                    count++;
                }
            }
        }
        return count;
    }

    private void visit(int i, int j, char [][]grid, boolean [][]visited) {
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0' || visited[i][j]) {
            return;
        }
        visited[i][j] = true;
        visit(i+1, j, grid, visited);
        visit(i-1, j, grid, visited);
        visit(i, j+1, grid, visited);
        visit(i, j-1, grid, visited);
    }
}
