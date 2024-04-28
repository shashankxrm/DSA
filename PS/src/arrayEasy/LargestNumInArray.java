package arrayEasy;

public class LargestNumInArray {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        System.out.println(largestElement(arr, 5));
    }
    static int largestElement(int[] arr, int n) {
        int ans = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] > ans){
                ans = arr[i];
            }
        }
        return ans;

    }

}