package BinarySearch;

public class mountainArrayIndex {
    public static void main(String[] args) {
        int[] arr ={1, 2, 3, 5, 7, 6, 3, 2};
        System.out.println(mountainPeak(arr));
    }
    static int mountainPeak(int[] arr){
        int start = 0;
        int end = arr.length - 1;
        while (start < end){
            int mid = start + (end - start) / 2;
            if (arr[mid] > arr[mid + 1]){
                // You are in dec part of array. This may be the ans, but look left too.
                end = mid;
            } else {
                // You are in asc part of array.
                start = mid + 1;
            }
        }
        // In the end, start == end points towards the largest num cos of 2 checks above.
        return start;
    }
}
