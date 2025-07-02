package dp.longestIncreasingSubSeq;
import java.util.Arrays;
// LC354: Russian Doll Envelopes
// You are given a 2D array of integers envelopes where envelopes[i] = [wi, hi] represents the width and height of an envelope.
// One envelope can fit into another if and only if both the width and height of one envelope are greater than the other.
// Return the maximum number of envelopes you can Russian doll (i.e., put one inside the other).
// Note: You cannot rotate envelopes.
// Example: Input: envelopes = [[5,4],[6,4],[6,7],[2,3]] Output: 3 (The maximum number of envelopes is 3: [2,3] -> [5,4] -> [6,7])
public class russianDollEnvelopes {
    public int maxEnvelopes(int[][] envelopes) { // Time: O(n log n), Space: O(n)
        if (envelopes.length == 0) return 0; // If the array is empty, return 0
        // Sort envelopes by width in ascending order and by height in descending order for equal widths
        Arrays.sort(envelopes, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
        int n = envelopes.length;
        int[] dp = new int[n]; // DP array to store the heights of increasing subsequences
        int length = 0; // Length of the longest increasing subsequence
        for (int[] envelope : envelopes) {
            int height = envelope[1];
            // Binary search to find the position to insert the current height
            int left = 0, right = length;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (dp[mid] < height) {
                    left = mid + 1; // Move right if current height is greater
                } else {
                    right = mid; // Move left if current height is less than or equal
                }
            }
            dp[left] = height; // Update the DP array with the current height
            if (left == length) length++; // Increase length if we added a new height
        }
        return length; // Return the length of the longest increasing subsequence of heights
    }
}
