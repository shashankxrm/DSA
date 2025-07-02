package backtracking;
import java.util.*;
// LC51: N-Queens
// The N-Queens puzzle is the problem of placing N chess queens on an N×N chessboard so that no two queens threaten each other.
// Given an integer n, return all distinct solutions to the N-Queens puzzle.
// Each solution contains a distinct board configuration of the N-Queens' placement, where 'Q' and '.' both indicate a
// queen and an empty space, respectively.
// Example: Input: n = 4 Output: [[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
public class nQueens {
    public List<List<String>> solveNQueens(int n) { // Time: O(n!), Space: O(n^2)
        List<List<String>> result = new ArrayList<>();
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.'); // Initialize the board with empty spaces
        }
        backtrack(result, board, 0, n);
        return result;
    }
    private void backtrack(List<List<String>> result, char[][] board, int row, int n) {
        if (row == n) { // All queens are placed
            result.add(construct(board)); // Add the current board configuration
            return;
        }
        for (int col = 0; col < n; col++) {
            if (isSafe(board, row, col, n)) { // Check if it's safe to place a queen
                board[row][col] = 'Q'; // Place the queen
                backtrack(result, board, row + 1, n); // Recur to place the next queen
                board[row][col] = '.'; // Backtrack to explore other positions
            }
        }
    }
    private boolean isSafe(char[][] board, int row, int col, int n) {
        for (int i = 0; i < row; i++) { // Check column
            if (board[i][col] == 'Q') return false;
        }
        for (int i = row - 1, j = col; i >= 0 && j >= 0; i--, j--) { // Check left diagonal
            if (board[i][j] == 'Q') return false;
        }
        for (int i = row - 1, j = col; i >= 0 && j < n; i--, j++) { // Check right diagonal
            if (board[i][j] == 'Q') return false;
        }
        return true; // Safe to place the queen
    }
    private List<String> construct(char[][] board) {
        List<String> result = new ArrayList<>();
        for (char[] row : board) {
            result.add(new String(row)); // Convert each row to a string
        }
        return result;
    }
}
