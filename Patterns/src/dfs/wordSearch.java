package dfs;

// LC79: Word Search
// Given an m x n grid of characters board and a string word, return true if word exists in the grid.
// The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring.
// The same letter cell may not be used more than once.
// Example 1: Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
// Output: false
public class wordSearch {
    public boolean exist(char[][] board, String word) { // Time: O(m * n * 4^k), Space: O(m * n)
        if (board == null || board.length == 0 || board[0].length == 0 || word == null || word.length() == 0) return false;
        int m = board.length, n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(board, visited, word, i, j, 0)) return true;
            }
        }
        return false;
    }
    private boolean dfs(char[][] board, boolean[][] visited, String word, int i, int j, int index) {
        if (index == word.length()) return true; // Found the word
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j] || board[i][j] != word.charAt(index)) {
            return false; // Out of bounds or already visited or character does not match
        }
        visited[i][j] = true; // Mark as visited
        boolean found = dfs(board, visited, word, i - 1, j, index + 1) || // up
                        dfs(board, visited, word, i + 1, j, index + 1) || // down
                        dfs(board, visited, word, i, j - 1, index + 1) || // left
                        dfs(board, visited, word, i, j + 1, index + 1);   // right
        visited[i][j] = false; // Unmark for other paths
        return found;
    }
}
