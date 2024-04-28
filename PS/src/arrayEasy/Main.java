package arrayEasy;

import java.util.HashSet;

public class Main {
    public static void main(String[] args) {

    }
    public int removeDuplicates(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        return set.size();
    }
}


