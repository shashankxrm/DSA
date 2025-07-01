package dfs;

// LC733: Flood Fill
// An image is represented by a 2D array of integers, each integer representing the pixel value of the image (from 0 to 65535).
// Given a coordinate (sr, sc) representing the starting pixel (row and column) of the flood fill, and a pixel value newColor,
// "flood fill" the image.
// To perform a "flood fill", consider the starting pixel, plus any pixels connected 4-directionally to the starting pixel
// of the same color as the starting pixel, plus any pixels connected 4-directionally to those pixels
// (also with the same color), and so on. Replace the color of all of the aforementioned pixels with the newColor.
// At the end, return the modified image.
// Example 1: Input: image = [[1,1,1],[1,1,0],[1,0,1]], sr = 1, sc = 1, newColor = 2
// Output: [[2,2,2],[2,2,0],[2,0,1]]
public class floodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) { // Time: O(m * n), Space: O(m * n)
        if (image == null || image.length == 0 || image[0].length == 0) return image;
        int m = image.length, n = image[0].length;
        int oldColor = image[sr][sc];
        if (oldColor == newColor) return image; // No need to change color
        dfs(image, sr, sc, oldColor, newColor);
        return image;
    }
    private void dfs(int[][] image, int i, int j, int oldColor, int newColor) {
        if (i < 0 || i >= image.length || j < 0 || j >= image[0].length || image[i][j] != oldColor) return;
        image[i][j] = newColor; // Change color
        dfs(image, i - 1, j, oldColor, newColor); // up
        dfs(image, i + 1, j, oldColor, newColor); // down
        dfs(image, i, j - 1, oldColor, newColor); // left
        dfs(image, i, j + 1, oldColor, newColor); // right
    }
}
