package BinarySearch;

public class ceiling {
    public static void main(String[] args) {
        int[] arr = {2, 3, 5, 9, 14, 16, 18};
        System.out.println(ceiling(arr, 10));
    }

    static int ceiling (int[] arr, int target){
        // ceiling -> Smallest ele greater than or equal to target.
        int start = 0;
        int end = arr.length - 1;
        while(start <= end){
            int mid = start + (end - start) / 2;
            if (target > arr[mid]){
                start = mid + 1;
            } else if(target < arr[mid]){
                end = mid - 1;
            } else {
                return arr[mid];
            }
        }

        return arr[start];
    }
}
