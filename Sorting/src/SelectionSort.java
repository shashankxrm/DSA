import java.lang.reflect.Array;
import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {3, 5, 1, 2, 4};
        SelectionSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    static void SelectionSort(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            // Find Max item in remaining Array and Swap with right index.
            int last = arr.length - i - 1;
            int max = maxEle(arr, 0, last);
            swap(arr, max, last);
        }
    }
    static int maxEle(int[] arr, int start, int end){
        int max = start;
        for (int i = start; i <= end ; i++) {
            if (arr[i] > arr[max]){
                max = i;
            }
        }
        return max;
    }
    static void swap(int[] arr, int first, int last){
        int temp = arr[first];
        arr[first] = arr[last];
        arr[last] = temp;
    }
}