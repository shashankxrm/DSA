package stackNqueue;

// LC 994 : Rotting Oranges
// In a given grid, each cell can have one of three values:
// the value 0 representing an empty cell;
// the value 1 representing a fresh orange;
// the value 2 representing a rotten orange.
// Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.
// Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1.
// Example 1:
// Input: grid = [[2,1,1],[1,1,0],[0,1,1]]
// Output: 4
// Example 2:
// Input: grid = [[2,1,1],[0,1,1],[1,0,1]]
// Output: -1

public class rottingOranges {
    public int orangesRotting(int[][] grid) { // O(n * m) O(n * m)
        int n = grid.length;
        int m = grid[0].length;
        java.util.Queue<int[]> queue = new java.util.LinkedList<>();
        int freshOranges = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 2){
                    queue.add(new int[]{i, j});
                } else if(grid[i][j] == 1){
                    freshOranges++;
                }
            }
        }
        if(freshOranges == 0){
            return 0;
        }
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int minutes = 0;
        while(!queue.isEmpty()){
            minutes++;
            int size = queue.size();
            for(int i = 0; i < size; i++){
                int[] curr = queue.poll();
                for(int[] dir : dirs){
                    int x = curr[0] + dir[0];
                    int y = curr[1] + dir[1];
                    if(x < 0 || y < 0 || x >= n || y >= m || grid[x][y] == 0 || grid[x][y] == 2){
                        continue;
                    }
                    grid[x][y] = 2;
                    queue.add(new int[]{x, y});
                    freshOranges--;
                }
            }
        }
        return freshOranges == 0 ? minutes - 1 : -1;
    }



    public int orangesRotting2(int[][] grid) { // O(n * m) O(1)
            if(grid == null || grid.length == 0) return -1;

            for(int i=0; i<grid.length; i++) {
                for(int j=0; j<grid[0].length; j++) {
                    if(grid[i][j] == 2) rotAdjacent(grid, i, j, 2);
                }
            }

            int minutes = 2;
            for(int[] row : grid) {
                for(int cell : row) {
                    if(cell == 1) return -1;
                    minutes = Math.max(minutes, cell);
                }
            }

            return minutes - 2;
        }

        private void rotAdjacent(int[][] grid, int i, int j, int minutes) {
            if(i < 0 || i >= grid.length /* out of bounds */
                    || j < 0 || j >= grid[0].length /* out of bounds */
                    || grid[i][j] == 0 /* empty cell */
                    || (1 < grid[i][j] && grid[i][j] < minutes) /* this orange is already rotten by another rotten orange */
            ) return;
            else {
                grid[i][j] = minutes;
                rotAdjacent(grid, i - 1, j, minutes + 1);
                rotAdjacent(grid, i + 1, j, minutes + 1);
                rotAdjacent(grid, i, j - 1, minutes + 1);
                rotAdjacent(grid, i, j + 1, minutes + 1);
            }
        }
    }


