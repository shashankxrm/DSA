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
    public static int countInversions(int[] nums) { // O(nlogn) time and O(n) space
        if (nums == null || nums.length < 2) {
            return 0;
        }
        return mergeSort(nums, 0, nums.length - 1);
    }

    private static int mergeSort(int[] nums, int left, int right) {
        if (left >= right) {
            return 0;
        }

        int mid = left + (right - left) / 2;
        int count = 0;

        // Recursively count inversions in left and right halves
        count += mergeSort(nums, left, mid);
        count += mergeSort(nums, mid + 1, right);

        // Count inversions across the two halves
        count += countCrossInversions(nums, left, mid, right);

        // Merge the two halves
        merge(nums, left, mid, right);

        return count;
    }

    private static int countCrossInversions(int[] nums, int left, int mid, int right) {
        int count = 0;
        int j = mid + 1;

        for (int i = left; i <= mid; i++) {
            while (j <= right && nums[i] > nums[j]) {
                j++;
            }
            count += (j - mid - 1);
        }

        return count;
    }

    private static void merge(int[] nums, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int i = left, j = mid + 1, k = 0;

        while (i <= mid && j <= right) {
            if (nums[i] <= nums[j]) {
                temp[k++] = nums[i++];
            } else {
                temp[k++] = nums[j++];
            }
        }

        while (i <= mid) {
            temp[k++] = nums[i++];
        }

        while (j <= right) {
            temp[k++] = nums[j++];
        }

        System.arraycopy(temp, 0, nums, left, temp.length);
    }

    public static void main(String[] args) {
        int[] arr = {2, 4, 1, 3, 5};
        System.out.println(countInversions(arr));
    }
}
