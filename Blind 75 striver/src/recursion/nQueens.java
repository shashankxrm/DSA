package recursion;

// LC 51 : N-Queens
// The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.
// Given an integer n, return all distinct solutions to the n-queens puzzle. You may return the answer in any order.
// Each solution contains a distinct board configuration
// where 'Q' and '.' both indicate a queen and an empty space, respectively.
// Example 1:
// Input: n = 4
// Output: [[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
// Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above
// Example 2:
// Input: n = 1
// Output: [["Q"]]

import java.util.*;

public class nQueens {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> solutions = new ArrayList<>();
        boolean[] columns = new boolean[n];
        boolean[] mainDiagonal = new boolean[2 * n];
        boolean[] antiDiagonal = new boolean[2 * n];
        char[][] board = new char[n][n];

        // Initialize the board with '.'
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }

        // Start placing queens
        placeQueens(0, n, board, solutions, columns, mainDiagonal, antiDiagonal);
        return solutions;
    }

    private void placeQueens(int row, int n, char[][] board, List<List<String>> solutions,
                             boolean[] columns, boolean[] mainDiagonal, boolean[] antiDiagonal) {
        if (row == n) {
            solutions.add(constructSolution(board));
            return;
        }

        for (int col = 0; col < n; col++) {
            int mainDiagIndex = row - col + n;
            int antiDiagIndex = row + col;

            // Check if placing a queen here is safe
            if (columns[col] || mainDiagonal[mainDiagIndex] || antiDiagonal[antiDiagIndex]) continue;

            // Place the queen
            board[row][col] = 'Q';
            columns[col] = mainDiagonal[mainDiagIndex] = antiDiagonal[antiDiagIndex] = true;

            // Recur for the next row
            placeQueens(row + 1, n, board, solutions, columns, mainDiagonal, antiDiagonal);

            // Backtrack: Remove the queen
            board[row][col] = '.';
            columns[col] = mainDiagonal[mainDiagIndex] = antiDiagonal[antiDiagIndex] = false;
        }
    }

    private List<String> constructSolution(char[][] board) {
        List<String> solution = new ArrayList<>();
        for (char[] row : board) {
            solution.add(new String(row));
        }
        return solution;
    }

}
