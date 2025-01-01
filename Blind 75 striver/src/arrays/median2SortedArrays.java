package arrays;

// LC 4 : Median of Two Sorted Arrays
// Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
// The overall run time complexity should be O(log (m+n)).
// Example 1:
// Input: nums1 = [1,3], nums2 = [2]
// Output: 2.00000
// Explanation: merged array = [1,2,3] and median is 2.
// Example 2:
// Input: nums1 = [1,2], nums2 = [3,4]
// Output: 2.50000
// Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.

public class median2SortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) { // O(log(min(m,n))) O(1)
        if(nums1.length > nums2.length){
            return findMedianSortedArrays(nums2, nums1);
        }
        int x = nums1.length;
        int y = nums2.length;
        int low = 0;
        int high = x;
        while(low <= high){
            int partitionX = (low + high) / 2;
            int partitionY = (x + y + 1) / 2 - partitionX;
            int maxX = partitionX == 0 ? Integer.MIN_VALUE : nums1[partitionX - 1];
            int minX = partitionX == x ? Integer.MAX_VALUE : nums1[partitionX];
            int maxY = partitionY == 0 ? Integer.MIN_VALUE : nums2[partitionY - 1];
            int minY = partitionY == y ? Integer.MAX_VALUE : nums2[partitionY];
            if(maxX <= minY && maxY <= minX){
                if((x + y) % 2 == 0){
                    return (double) (Math.max(maxX, maxY) + Math.min(minX, minY)) / 2;
                } else {
                    return (double) Math.max(maxX, maxY);
                }
            } else if(maxX > minY){
                high = partitionX - 1;
            } else {
                low = partitionX + 1;
            }
        }
        throw new IllegalArgumentException();
    }
}
