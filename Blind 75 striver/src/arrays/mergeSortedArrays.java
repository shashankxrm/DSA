package arrays;

// LC 88 : Merge Sorted Array
// You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n,
// representing the number of elements in nums1 and nums2 respectively.
// Merge nums1 and nums2 into a single array sorted in non-decreasing order.
// The final sorted array should not be returned by the function, but instead be stored inside the array nums1.
// To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should be merged,
// and the last n elements are set to 0 and should be ignored. nums2 has a length of n.
// Example 1:
// Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
// Output: [1,2,2,3,5,6]
// Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
// The result of the merge is [1,2,2,3,5,6] with the underlined elements coming from nums1.
// Example 2:
// Input: nums1 = [1], m = 1, nums2 = [], n = 0
// Output: [1]
// Explanation: The arrays we are merging are [1] and [].
// The result of the merge is [1].


import java.util.Arrays;

public class mergeSortedArrays {
    static void merge2(int[] nums1, int m, int[] nums2, int n) { // time : O(m+n), space : O(1)
        int i = m - 1, j = n - 1, k = m + n - 1;
        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                // Place the larger element at the end
                nums1[k] = nums1[i];
                i--; // Move nums1 pointer backward
            } else {
                nums1[k] = nums2[j];
                j--; // Move nums2 pointer backward
            }
            k--; // Move the nums1 placement pointer backward
        }

        // If there are remaining elements in nums2, copy them into nums1
        // (Remaining nums1 elements are already in place, so no need to handle that case)
        while (j >= 0) {
            nums1[k] = nums2[j];
            j--; // Move nums2 pointer backward
            k--; // Move nums1 placement pointer backward
        }
    }
    static void merge(int[] nums1, int m, int[] nums2, int n) { // time : O((m+n)log(m+n)), space : O(1)
        if(n == 0)return;
        if (m == 0) {
            for (int i = 0; i < n; i++) {
                nums1[i] = nums2[i];
            }
            return;
        }
        int j = 0;
            for (int i = m; i < nums1.length; i++) {
                nums1[i] = nums2[j];
                j++;
                if(j == n)break;
            }

        Arrays.sort(nums1);
    }
    // better approach


    public static void main(String[] args) {
        int[] nums1 = {1};
        int m = 1;
        int[] nums2 = {2,5,6};
        int n = 3;
        merge(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));


    }
}
