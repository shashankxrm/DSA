package BFS;
import java.util.*;
// LC1091: Shortest Path in Binary Matrix
// In an N x N binary matrix grid, each cell is either 0 (empty) or 1 (obstacle). A path from the top-left cell to the
// bottom-right cell exists if and only if it is possible to travel from the top-left cell to the bottom-right cell by
// moving left, right, up, down, or diagonally to adjacent cells that are empty (0). The shortest path in the binary
// matrix is the number of steps in the path. If there is no path, return -1.
// Example 1: Input: grid = [[0,1],[1,0]] Output: 2 Explanation: There is a path from the top-left to the bottom-right
// cell with a length of 2.
public class shortestPathinBinaryMatrix {
    public int shortestPathBinaryMatrix(int[][] grid) { // Time: O(n^2), Space: O(n^2)
        int n = grid.length;
        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1) return -1; // No path if start or end is blocked
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}}; // All 8 directions
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0}); // Start from the top-left cell
        grid[0][0] = 1; // Mark as visited
        int steps = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            steps++;
            for (int i = 0; i < size; i++) {
                int[] cell = queue.poll();
                int x = cell[0], y = cell[1];
                if (x == n - 1 && y == n - 1) return steps; // Reached the bottom-right cell
                for (int[] dir : directions) {
                    int newX = x + dir[0], newY = y + dir[1];
                    if (newX >= 0 && newX < n && newY >= 0 && newY < n && grid[newX][newY] == 0) {
                        grid[newX][newY] = 1; // Mark as visited
                        queue.offer(new int[]{newX, newY});
                    }
                }
            }
        }
        return -1; // No path found
    }
}
