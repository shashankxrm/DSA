package BFS;
import java.util.*;
// LC773: Sliding Puzzle
// In a 2x3 grid, there are 5 tiles numbered from 1 to 5 and one empty space represented by 0. The goal is to move the
// tiles around to reach a target configuration. The tiles can be moved into the empty space, and the goal is to find the
// minimum number of moves required to reach the target configuration. If it is impossible to reach the target, return -1.
// Example 1: Input: board = [[1,2,3],[4,0,5]], target = [[1,2,3],[4,5,0]] Output: 1
// Example 2: Input: board = [[1,2,3],[5,4,0]], target = [[1,2,3],[4,5,0]] Output: -1
public class slidingPuzzle {
    public int slidingPuzzle(int[][] board) { // Time: O(1), Space: O(1)
        String start = boardToString(board);
        String target = "123450"; // Target configuration
        if (start.equals(target)) return 0; // Already in target configuration
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}}; // Possible moves
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.offer(start);
        visited.add(start);
        int moves = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String current = queue.poll();
                if (current.equals(target)) return moves; // Found the target
                int zeroIndex = current.indexOf('0'); // Find the empty space
                int row = zeroIndex / 3, col = zeroIndex % 3; // Convert to row and column
                for (int[] dir : directions) {
                    int newRow = row + dir[0], newCol = col + dir[1];
                    if (newRow >= 0 && newRow < 2 && newCol >= 0 && newCol < 3) { // Valid move
                        String nextState = swap(current, zeroIndex, newRow * 3 + newCol);
                        if (!visited.contains(nextState)) {
                            visited.add(nextState);
                            queue.offer(nextState);
                        }
                    }
                }
            }
            moves++;
        }
        return -1; // Target not reachable
    }
    private String boardToString(int[][] board) {
        StringBuilder sb = new StringBuilder();
        for (int[] row : board) {
            for (int num : row) {
                sb.append(num);
            }
        }
        return sb.toString();
    }
    private String swap(String s, int i, int j) {
        char[] chars = s.toCharArray();
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
        return new String(chars);
    }
}
