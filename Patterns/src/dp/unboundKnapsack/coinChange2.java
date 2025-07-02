package dp.unboundKnapsack;
// LC518: Coin Change 2
// You are given an integer array coins representing coins of different denominations and an integer amount representing
// a total amount of money. You want to make up that amount by using the coins.
// Return the number of combinations that make up that amount. If that amount of money cannot be made up by any combination
// of the coins, return 0. You may assume that you have an infinite number of each kind of coin.
// Example: Input: coins = [1,2,5], amount = 5 Output: 4 (Combinations are: [1,1,1,1,1], [1,1,1,2], [1,2,2], [5])
public class coinChange2 {
    public int change(int amount, int[] coins) { // Time: O(n * amount), Space: O(amount)
        int[] dp = new int[amount + 1]; // DP array to track combinations for each amount
        dp[0] = 1; // Base case: one way to make amount 0 (using no coins)
        for (int coin : coins) { // Iterate through each coin
            for (int i = coin; i <= amount; i++) { // Update DP array for amounts >= coin value
                dp[i] += dp[i - coin]; // Add combinations from previous amounts
            }
        }
        return dp[amount]; // Return the number of combinations for the target amount
    }
}
