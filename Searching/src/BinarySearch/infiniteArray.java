package BinarySearch;

public class infiniteArray {
    public static void main(String[] args) {
        int[] arr = {93, 9, 24, 69, 83, 82};
        System.out.println(ans(arr, 83));
    }
    static int ans(int[] arr, int target){
        // First find the range
        // First start with a box of size of 2
        int start = 0;
        int end = 1;
        // Condition for the target to lie in the range
        while (target > arr[end]){
            int temp = end + 1; // This is my new start.
            //double the box value.
            // end = end + (end - start + 1) * 2
            end = end + (end - start + 1) * 2;
            start = temp;
        }
        return binarySearch(arr, target, start, end);
    }
    static int binarySearch(int[] arr, int target, int start, int end){
        while(start <= end){
            int mid = start + (end - start) / 2;
            if (target > arr[mid]){
                start = mid + 1;
            } else if(target < arr[mid]){
                end = mid - 1;
            } else {
                return mid;
            }
        }

        return -1;
    }
}

