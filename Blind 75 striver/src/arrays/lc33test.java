package arrays;

public class lc33test {
    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int target = 0;
        System.out.println(pivot(nums));
    }

    static int pivot(int[] nums) {
        int s = 0;
        int e = nums.length - 1;
        while(s < e){
            int m = s + (e -s)/2;
            if(nums[m] > e){
                s = m + 1;
            } else {
                e = m;
            }
        }
        return s;
    }

}
