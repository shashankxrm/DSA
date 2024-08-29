package dp;

// LC 213 : House Robber II
// You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed.
// All houses at this place are arranged in a circle. That means the first house is the neighbor of the last one.
// Meanwhile, adjacent houses have a security system connected, and it will automatically contact the police if two
// adjacent houses were broken into on the same night.
// Given a list of non-negative integers nums representing the amount of money of each house, return the maximum amount
// of money you can rob tonight without alerting the police.
// Example 1:
// Input: nums = [2,3,2]
// Output: 3
// Input: nums = [1,2,3,1]
// Output: 4


public class houseRobber2 {
    // solution using dp
    public int robCircle(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int[] skipLastHouse = new int[nums.length - 1];
        int[] skipFirstHouse = new int[nums.length - 1];

        for(int i = 0; i < nums.length - 1; i++){
            skipLastHouse[i] = nums[i];
            skipFirstHouse[i] = nums[i + 1];
        }
        int lootSkippingLast = rob(skipLastHouse);
        int lootSkippingFirst = rob(skipFirstHouse);

        return Math.max(lootSkippingLast, lootSkippingFirst);

    }
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int[] dp = new int[nums.length];
        // case 1: if we rob the first house
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max( dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[nums.length - 1];

    }
    public static void main(String[] args) {
        houseRobber2 obj = new houseRobber2();
        int[] nums = {2,3,2};
        System.out.println(obj.robCircle(nums));
    }

}
