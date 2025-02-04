package BS;

// LC 378 : Kth Smallest Element in a Sorted Matrix
// Given an n x n matrix where each of the rows and columns are sorted in ascending order, return the kth smallest
// element in the matrix.
// Note that it is the kth smallest element in the sorted order, not the kth distinct element.
// Example 1:
// Input: matrix = [[1,5,9],[10,11,13],[12,13,15]], k = 8
// Output: 13

import java.util.*;

public class KthSmallestEleInSortedMatrix {
    public int kthSmallest(int[][] matrix, int k) { // O(nlogn) O(n)
        int n = matrix.length;
        int low = matrix[0][0], high = matrix[n - 1][n - 1];
        while(low < high){
            int mid = low + (high - low) / 2;
            int count = 0;
            for(int i = 0; i < n; i++){
                int j = n - 1;
                while(j >= 0 && matrix[i][j] > mid){
                    j--;
                }
                count += j + 1;
            }
            if(count < k){
                low = mid + 1;
            }else{
                high = mid;
            }
        }
        return low;
    }
}
