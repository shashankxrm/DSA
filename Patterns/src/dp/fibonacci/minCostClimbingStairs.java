package dp.fibonacci;
// LC746: Min Cost Climbing Stairs
// You are given an integer array cost where cost[i] is the cost of ith step on a staircase.
// Once you pay the cost, you can either climb one or two steps. You can either start from the step with index 0,
// or the step with index 1. Return the minimum cost to reach the top of the floor.
// Example: Input: cost = [10,15,20] Output: 15 (Start at index 1, climb to index 2)
public class minCostClimbingStairs {
    public int minCostClimbingStairs(int[] cost) { // Time: O(n), Space: O(1)
        int n = cost.length;
        if (n == 0) return 0; // No steps
        if (n == 1) return cost[0]; // Only one step
        if (n == 2) return Math.min(cost[0], cost[1]); // Two steps, choose the cheaper one
        int first = cost[0]; // Cost to reach step 0
        int second = cost[1]; // Cost to reach step 1
        for (int i = 2; i < n; i++) {
            int current = cost[i] + Math.min(first, second); // Current cost is the step cost plus the min of the last two costs
            first = second; // Move to the next step
            second = current; // Update the second step
        }
        return Math.min(first, second); // Return the minimum cost to reach the top
    }
}
