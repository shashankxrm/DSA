package BFS;
import java.util.*;
// LC994: Rotting Oranges
// In a given grid, each cell can have one of three values:
// 0 representing an empty cell, 1 representing a fresh orange, or 2 representing a rotten orange. Every minute,
// any fresh orange that is adjacent (4-directionally) to a rotten orange becomes rotten. Return the minimum number of
// minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1.
// Example 1: Input: grid = [[2,1,1],[1,1,0],[0,1,1]] Output: 4
public class rottingOranges {
    public int orangesRotting(int[][] grid) { // Time: O(m * n), Space: O(m * n)
        int m = grid.length, n = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int freshCount = 0;
        // Initialize the queue with rotten oranges and count fresh oranges
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    freshCount++;
                }
            }
        }
        if (freshCount == 0) return 0; // No fresh oranges
        int minutes = 0;
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean hasRotten = false;
            for (int i = 0; i < size; i++) {
                int[] pos = queue.poll();
                for (int[] dir : directions) {
                    int x = pos[0] + dir[0], y = pos[1] + dir[1];
                    if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == 1) {
                        grid[x][y] = 2; // Make it rotten
                        freshCount--;
                        queue.offer(new int[]{x, y});
                        hasRotten = true;
                    }
                }
            }
            if (hasRotten) minutes++;
        }
        return freshCount == 0 ? minutes : -1; // If all fresh oranges are rotten
    }
}
