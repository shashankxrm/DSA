package Matrix;

// LC 79 : Word Search
// Given an m x n board and a word, find if the word exists in the grid.
// The word can be constructed from letters of sequentially adjacent cells, where "adjacent" cells are horizontally or
// vertically neighboring.
// The same letter cell may not be used more than once.
// Example 1:
// Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
// Output: true
// Example 2:
// Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
// Output: true


public class wordSearch {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == word.charAt(0) && dfs(board, i, j, word, 0, visited)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, int i, int j, String word, int index, boolean[][] visited){
        if(index == word.length()){
            return true;
        }

        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j] || board[i][j] != word.charAt(index)){
            return false;
        }

        visited[i][j] = true;
        if(dfs(board, i+1, j, word, index+1, visited) ||
                dfs(board, i-1, j, word, index+1, visited) ||
                dfs(board, i, j+1, word, index+1, visited) ||
                dfs(board, i, j-1, word, index+1, visited)){
            return true;
        }
        visited[i][j] = false;
        return false;
    }
}
