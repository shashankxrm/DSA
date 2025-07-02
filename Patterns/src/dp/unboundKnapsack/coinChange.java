package dp.unboundKnapsack;
// LC322: Coin Change
// You are given an integer array coins representing coins of different denominations and an integer amount representing
// a total amount of money. You want to make up that amount by using the coins.
// Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any
// combination of the coins, return -1.
// You may assume that you have an infinite number of each kind of coin.
// Example: Input: coins = [1,2,5], amount = 11 Output: 3 (11 can be made with 5 + 5 + 1)
public class coinChange {
    public int coinChange(int[] coins, int amount) { // Time: O(n * amount), Space: O(amount)
        int[] dp = new int[amount + 1]; // DP array to track minimum coins for each amount
        for (int i = 1; i <= amount; i++) {
            dp[i] = Integer.MAX_VALUE; // Initialize with a large value
            for (int coin : coins) {
                if (i - coin >= 0 && dp[i - coin] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1); // Update minimum coins needed
                }
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount]; // Return -1 if amount cannot be made, else return the count
    }
}
