package greedyAlgo;

// Given an amount, find the minimum number of coins required to make the exact amount.
// Example 1:
// Input: coins = {1, 2, 5}, amount = 11
// Output: 3
// Explanation: 11 = 5 + 5 + 1
// Example 2:
// Input: coins = {2}, amount = 3
// Output: -1
// Explanation: You cannot make the exact amount of 3 with coins of 2.


public class minNumofCoins {
    public int coinChange(int[] coins, int amount) { // O(n * amount) O(amount)
        int[] dp = new int[amount + 1];
        java.util.Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for(int i = 1; i <= amount; i++){
            for(int coin : coins){
                if(coin <= i){
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
