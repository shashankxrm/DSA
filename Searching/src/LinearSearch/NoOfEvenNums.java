package LinearSearch;

public class NoOfEvenNums {
    public static void main(String[] args) {
        int[] nums = {12, 345, 2, 6, 7896};
        System.out.println(findNums(nums));
    }
    static int findNums(int[] nums){
        int count = 0;
        for (int i : nums) {
            if (even(i)){
                count++;
            } else {
                i++;
            }
        }
        return count;
    }
    static boolean even(int num){
        int dig = 0;
        while (num > 0){
            dig++;
            num = num / 10;
        }
        return (dig % 2 == 0);
    }
}
