package backtracking;

// LC52: N-Queens II
// The N-Queens II puzzle is the problem of placing N chess queens on an N×N chessboard so that no two queens threaten each other.
// Given an integer n, return the number of distinct solutions to the N-Queens II puzzle.
// Example: Input: n = 4 Output: 2
// The two distinct solutions are:
// [[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
public class nQueens2 {
    public int totalNQueens(int n) { // Time: O(n!), Space: O(n^2)
        return backtrack(0, new boolean[n], new boolean[2 * n], new boolean[2 * n], n);
    }
    private int backtrack(int row, boolean[] cols, boolean[] diag1, boolean[] diag2, int n) {
        if (row == n) return 1; // All queens are placed successfully
        int count = 0;
        for (int col = 0; col < n; col++) {
            if (!cols[col] && !diag1[row + col] && !diag2[row - col + n]) { // Check if it's safe to place a queen
                cols[col] = diag1[row + col] = diag2[row - col + n] = true; // Place the queen
                count += backtrack(row + 1, cols, diag1, diag2, n); // Recur to place the next queen
                cols[col] = diag1[row + col] = diag2[row - col + n] = false; // Backtrack to explore other positions
            }
        }
        return count; // Return the total count of solutions found
    }
}
