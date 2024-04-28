package BSeasy;

public class mountainPeak {
    static int mountainPeakIndex(int[] nums){
        int s = 0, e = nums.length - 1, m = 0;
        while (s <= e){
            m = s + (e - s) / 2;
            if (nums[m + 1] < nums[m] && nums[m - 1] < nums[m]){
                return m;
            }
            if (nums[m + 1] > nums[m]){
                s = m + 1;
            } else {
                e = m - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {5, 6, 7, 1, 2, 3, 4};
        System.out.println(mountainPeakIndex(nums));
    }
}
