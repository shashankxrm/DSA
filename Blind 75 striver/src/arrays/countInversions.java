package arrays;

// coding problem: https://www.geeksforgeeks.org/counting-inversions/
// Given an array of integers. Find the Inversion Count in the array.
// Inversion Count: For an array, inversion count indicates how far (or close) the array is from being sorted.
// If the array is already sorted, then the inversion count is 0. If an array is sorted in the reverse order,
// the inversion count is the maximum. Formally, two elements a[i] and a[j] form an inversion if a[i] > a[j] and i < j.
// Example 1:
// Input: N = 5, arr[] = {2, 4, 1, 3, 5}
// Output: 3
// Explanation: The sequence 2, 4, 1, 3, 5 has three inversions (2, 1), (4, 1), (4, 3).
// Example 2:
// Input: N = 5, arr[] = {2, 3, 4, 5, 6}
// Output: 0
// Explanation: As the sequence is already sorted so there is no inversion count.

public class countInversions {
    static long inversionCount(long arr[], long N) {
        return mergeSortAndCount(arr, 0, N - 1);
    }

    static long mergeSortAndCount(long[] arr, long l, long r) {
        long count = 0;
        if (l < r) {
            long m = l + (r - l) / 2;
            count += mergeSortAndCount(arr, l, m);
            count += mergeSortAndCount(arr, m + 1, r);
            count += mergeAndCount(arr, l, m, r);
        }
        return count;
    }

    static long mergeAndCount(long[] arr, long l, long m, long r) {
        long[] left = new long[(int) (m - l + 1)];
        long[] right = new long[(int) (r - m)];

        for (int i = 0; i < left.length; i++) {
            left[i] = arr[(int) (l + i)];
        }
        for (int i = 0; i < right.length; i++) {
            right[i] = arr[(int) (m + 1 + i)];
        }

        long i = 0, j = 0, k = l, swaps = 0;
        while (i < left.length && j < right.length) {
            if (left[(int) i] <= right[(int) j]) {
                arr[(int) k++] = left[(int) i++];
            } else {
                arr[(int) k++] = right[(int) j++];
                swaps += (m + 1) - (l + i);
            }
        }

        while (i < left.length) {
            arr[(int) k++] = left[(int) i++];
        }
        while (j < right.length) {
            arr[(int) k++] = right[(int) j++];
        }

        return swaps;
    }

    public static void main(String[] args) {
        long[] arr = {2, 4, 1, 3, 5};
        System.out.println(inversionCount(arr, arr.length));
    }
}
