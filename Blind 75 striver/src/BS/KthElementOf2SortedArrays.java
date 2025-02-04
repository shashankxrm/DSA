package BS;

// Given two sorted arrays a[] and b[] and an element k, the task is to find the element that would be at the kth
// position of the combined sorted array.
// Examples:
// Input: a[] = {2, 3, 6, 7, 9}, b[] = {1, 4, 8, 10}, k = 5
// Output: 6
// Explanation: The combined sorted array would be {1, 2, 3, 4, 6, 7, 8, 9, 10}. The 5th element is 6.
// Input: a[] = {100, 112, 256, 349, 770}, b[] = {72, 86, 113, 119, 265, 445, 892}, k = 7
// Output: 256
// Explanation: The combined sorted array would be {72, 86, 100, 112, 113, 119, 256, 265, 349, 445, 770, 892}. The 7th element is 256.

import java.util.*;

public class KthElementOf2SortedArrays {
    public int kthElement(int[] a, int[] b, int k) { // O(log(min(n, m))) O(1)
        int n = a.length;
        int m = b.length;
        if(n > m){
            return kthElement(b, a, k);
        }
        int low = Math.max(0, k - m);
        int high = Math.min(k, n);
        while(low < high){
            int cut1 = low + (high - low) / 2;
            int cut2 = k - cut1;
            int l1 = cut1 == 0 ? Integer.MIN_VALUE : a[cut1 - 1];
            int l2 = cut2 == 0 ? Integer.MIN_VALUE : b[cut2 - 1];
            int r1 = cut1 == n ? Integer.MAX_VALUE : a[cut1];
            int r2 = cut2 == m ? Integer.MAX_VALUE : b[cut2];
            if(l1 <= r2 && l2 <= r1){
                return Math.max(l1, l2);
            } else if(l1 > r2){
                high = cut1 - 1;
            } else {
                low = cut1 + 1;
            }
        }
        return -1;
    }
}
