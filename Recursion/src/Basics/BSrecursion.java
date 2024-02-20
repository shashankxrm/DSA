package Basics;

public class BSrecursion {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 55, 66};
        int target = 55;
        System.out.println(BS(arr, target, 0, arr.length - 1));
    }
    static int BS(int[] arr, int target, int start, int end) {
        // base condition
        if (start > end){
            return -1;
        }
        int mid = start + (end - start)/ 2;
        if (target == arr[mid]){
            return mid;
        }
        if (target > arr[mid]){
            return BS(arr, target, mid + 1, end);
        }
        return BS(arr, target, start, end - 1);
    }
}