package arrays;

// LC 645 : Set Mismatch
// You have a set of integers s, which originally contains all the numbers from 1 to n. Unfortunately, due to some error,
// one of the numbers in s got duplicated to another number in the set, which results in repetition of one number and loss of another number.
// You are given an integer array nums representing the data status of this set after the error.
// Find the number that occurs twice and the number that is missing and return them in the form of an array.
// Example 1:
// Input: nums = [1,2,2,4]
// Output: [2,3]
// Example 2:
// Input: nums = [1,1]
// Output: [1,2]


public class repeatnMissingNumArray {
    public int[] repeatedNumber(final int[] nums) { // time : O(n), space : O(1)
        int n = nums.length;
        long expectedSum = (long) n * (n + 1) / 2;
        long expectedSquareSum = (long) n * (n + 1) * (2 * n + 1) / 6;

        long actualSum = 0, actualSquareSum = 0;
        for (int num : nums) {
            actualSum += num;
            actualSquareSum += (long) num * num;
        }

        long diff = expectedSum - actualSum; // x - y
        long sum = (expectedSquareSum - actualSquareSum) / diff; // x + y

        int x = (int) (diff + sum) / 2; // missing number
        int y = (int) (sum - x); // repeated number

        return new int[]{y, x};
    }
    // using cyclic sort
    public int[] findErrorNums(int[] nums) { // time : O(n), space : O(1)
        int i = 0;
        while (i < nums.length) {
            if (nums[i] != nums[nums[i] - 1]) {
                swap(nums, i, nums[i] - 1);
            } else {
                i++;
            }
        }
        for (i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return new int[]{nums[i], i + 1};
            }
        }
        return new int[]{};
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
