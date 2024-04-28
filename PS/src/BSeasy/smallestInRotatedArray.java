package BSeasy;

public class smallestInRotatedArray {
    static int findMin(int[] nums) {
        int pivot = pivot(nums);
        if(pivot == -1){
            return nums[0];
        }
        return nums[pivot];

    }
    static int pivot(int[] nums){
        int s = 0, e = nums.length - 1;
        while (s < e) {
            int m = s + (e - s) / 2;
            if (nums[m] > nums[e]) {
                s = m + 1;
            } else {
                e = m;
            }
        }
        return s;
    }

    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
        System.out.println(findMin(nums));
    }
}
