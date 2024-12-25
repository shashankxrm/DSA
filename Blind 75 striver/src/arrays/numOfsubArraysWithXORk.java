package arrays;

// LC 1442 : Count Triplets That Can Form Two Arrays of Equal XOR
// Given an array of integers arr.
// We want to select three indices i, j and k where (0 <= i < j <= k < arr.length).
// Let's define a and b as follows:
// a = arr[i] ^ arr[i + 1] ^ ... ^ arr[j - 1]
// b = arr[j] ^ arr[j + 1] ^ ... ^ arr[k]
// Note that ^ denotes the bitwise-xor operation.
// Return the number of triplets (i, j and k) Where a == b.
// Example 1:
// Input: arr = [2,3,1,6,7]
// Output: 4
// Explanation: The triplets are (0,1,2), (0,2,2), (2,3,4) and (2,4,4)

import java.util.*;

public class numOfsubArraysWithXORk {
    public int countTriplets(int[] arr) { // O(n^2) time and O(1) space
        int n = arr.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            int xor = arr[i];
            for (int j = i + 1; j < n; j++) {
                xor ^= arr[j];
                if (xor == 0) {
                    count += j - i;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        numOfsubArraysWithXORk obj = new numOfsubArraysWithXORk();
        int[] arr = {2, 3, 1, 6, 7};
        System.out.println(obj.countTriplets(arr));
    }
}
