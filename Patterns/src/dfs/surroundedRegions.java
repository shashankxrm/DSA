package dfs;

// LC130: Surrounded Regions
// Given an m x n matrix board containing 'X' and 'O', capture all regions that are 4-directionally surrounded by 'X'.
// A region is captured by flipping all 'O's into 'X's in that surrounded region.
// Example 1: Input: board = [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X","X"]]
// Output: [["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]]
public class surroundedRegions {
    public void solve(char[][] board) { // Time: O(m * n), Space: O(m * n)
        if (board == null || board.length == 0 || board[0].length == 0) return;
        int m = board.length, n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if ((i == 0 || i == m - 1 || j == 0 || j == n - 1) && board[i][j] == 'O') {
                    dfs(board, i, j);
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X'; // Flip surrounded 'O's to 'X's
                } else if (board[i][j] == 'E') {
                    board[i][j] = 'O'; // Restore boundary 'O's
                }
            }
        }
    }
    private void dfs(char[][] board, int i, int j) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != 'O') return;
        board[i][j] = 'E'; // Mark as escaped
        dfs(board, i - 1, j); // up
        dfs(board, i + 1, j); // down
        dfs(board, i, j - 1); // left
        dfs(board, i, j + 1); // right
    }
}
