package graphs;
// LC 128 : Longest Consecutive Sequence
// Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
// You must write an algorithm that runs in O(n) time.
// Example 1:
// Input: nums = [100,4,200,1,3,2]
// Output: 4
// Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
// Example 2:
// Input: nums = [0,3,7,2,5,8,4,6,0,1]
// Output: 9
// Explanation: The longest consecutive elements sequence is [0, 1, 2, 3, 4, 5, 6, 7, 8]. Therefore its length is 9.

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class longestConseqSequence {
    public static void main(String[] args) {
        int[] nums = {100, 4, 200, 1, 3, 2};
        //System.out.println(longestConsecutive(nums));
    }
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0)return 0;
        if(nums.length < 10000){
            Arrays.sort(nums);
            int longest = 0;
            int current = 0;
            int prev = nums[0] - 2;
            for(int num : nums){
                if(num == prev)continue;
                if(num - prev == 1){
                    current += 1;
                }
                else{
                    longest = Math.max(longest, current);
                    current = 1;
                }
                prev = num;
            }
            return Math.max(longest, current);
        }
        else{
            int min = nums[0];
            int max = nums[0];
            for(int num : nums){
                if(num < min){
                    min = num;
                }
                else if(num > max){
                    max = num;
                }
            }
            int range = max - min + 1;
            boolean[] isObserved = new boolean[range + 1];
            for(int num : nums){
                int index = (num - min);
                isObserved[index] = true;
            }

            int longest = 0;
            int current = 0;
            for(boolean _isObserved : isObserved){
                if(_isObserved){
                    current += 1;
                }
                else{
                    longest = Math.max(longest, current);
                    current = 0;
                }
            }

            return Math.max(longest, current);
        }
    }
    static int longestConsecutive2(int[] nums) { //  O(n) time and O(n) space
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int max = 0;
        for (int num : nums) {
            if (!set.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;
                while (set.contains(currentNum + 1)) {
                    currentNum++;
                    currentStreak++;
                }
                max = Math.max(max, currentStreak);
            }
        }
        return max;
    }
}
