import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {3, 5, 4, 1, 2};
        bubble(arr);
        System.out.println(Arrays.toString(arr));

    }
    static void bubble(int[] arr){
        // run the steps n - 1 times
        for (int i = 0; i < arr.length; i++) {
            boolean swapped = false;
            // for each step max item will come at the last respective index.
            for (int j = 1; j <= arr.length - i - 1; j++) {
                // swap if the item is smaller than the prev.
                if (arr[j] < arr[j - 1]){
                    // Swap
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                    swapped = true;
                }
            }
            // if u don't swap for a particular value of i, it means array is sorted. Hence Stop.
            if (!swapped){
                break;
            }
        }
    }
}
