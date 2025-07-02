package dp.zeroOneKnapsack;
// LC1049: Last Stone Weight II
// You are given an array of integers stones where stones[i] is the weight of the ith stone.
// We are playing a game with the stones. On each turn, we choose the two heaviest stones and smash them together.
// Suppose the stones have weights x and y with x <= y. The result of this smash is:
// If x == y, both stones are destroyed, and the result is 0.
// If x != y, the stone of weight x is destroyed, and the stone of weight y has new weight y - x.
// At the end of the game, there is at most one stone left.
// Return the weight of the last remaining stone. If there are no stones left, return 0.
// Example: Input: stones = [2,7,4,1,8,1] Output: 1 (The last remaining stone has weight 1)
public class lastStoneWeight2 {
    public int lastStoneWeightII(int[] stones) { // Time: O(n * sum), Space: O(sum)
        int sum = 0; // Initialize sum of the array
        for (int stone : stones) {
            sum += stone; // Calculate total sum of stones
        }
        int target = sum / 2; // Target is half of the total sum
        boolean[] dp = new boolean[target + 1]; // DP array to track achievable sums
        dp[0] = true; // Zero sum is always achievable
        for (int stone : stones) { // Iterate through each stone
            for (int j = target; j >= stone; j--) { // Update DP array in reverse order
                dp[j] |= dp[j - stone]; // Mark current sum as achievable if previous was achievable
            }
        }
        for (int i = target; i >= 0; i--) { // Find the largest achievable sum <= target
            if (dp[i]) {
                return sum - 2 * i; // Return the weight of the last remaining stone
            }
        }
        return 0; // If no stones left, return 0
    }
}
