package dp.fibonacci;
// LC70: Climbing Stairs
// You are climbing a staircase. It takes n steps to reach the top.
// Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
// Example: Input: n = 3 Output: 3 (Ways: [1,1,1], [1,2], [2,1])
public class climbingStairs {
    public int climbStairs(int n) { // Time: O(n), Space: O(1)
        if (n <= 2) return n; // Base cases
        int first = 1, second = 2; // Ways to climb 1 and 2 steps
        for (int i = 3; i <= n; i++) {
            int current = first + second; // Current ways is the sum of the previous two
            first = second; // Move to the next step
            second = current; // Update the second step
        }
        return second; // Return the total ways to climb n steps
    }
}
