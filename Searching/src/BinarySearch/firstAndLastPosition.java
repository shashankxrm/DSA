package BinarySearch;

import java.util.Arrays;

public class firstAndLastPosition {
    public static void main(String[] args) {
        int[] nums = {7, 8, 8, 10};
        System.out.println(Arrays.toString(position(nums, 8)));
    }
    static int[][] position(int[] nums, int target){
        int start = 0;
        int end = nums.length - 1;
        while(start <= end){
            int mid = start + (end - start) / 2;
            if (target > nums[mid]){
                start = mid + 1;
            } else if(target < nums[mid]){
                end = mid - 1;
            } else {
                if (nums[mid] == nums[mid + 1]){
                    return new int[][]{new int[]{mid, mid + 1}};
                } else {
                    return new int[][]{new int[]{mid, mid - 1}};
                }
        }

        }
        return new int[][]{new int[]{-1, - 1}};

    }
}
