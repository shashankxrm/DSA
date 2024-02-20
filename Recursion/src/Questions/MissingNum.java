package Questions;

import static java.lang.System.*;

public class MissingNum {
    public static void main(String[] args) {
        int[] nums = {9,6,4,2,3,5,7,0,1};
        int max = maxNum(nums);
        int sum = max * (max + 1)/2;
        int ans = sum - sumArr(nums);
        if (ans == 0){
            System.out.println(0);
        } else {
            out.println(ans);
        }
    }


    static int maxNum(int[] nums){
        int max = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max){
                max = nums[i];
            }
        }
        return max;
    }
    static int sumArr(int[] nums){
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];
        }
        return sum;
    }




}
