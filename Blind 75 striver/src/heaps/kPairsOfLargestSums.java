package heaps;

// LC 373 : Find K Pairs with Largest Sums
// You are given two integer arrays nums1 and nums2 sorted in non-decreasing order and an integer k.
// Define a pair (u,v) which consists of one element from the first array and one element from the second array.
// Find the k pairs (u1,v1),(u2,v2) ...(uk,vk) with the largest sums.
// Example 1:
// Input: nums1 = [1,7,11], nums2 = [2,4,6], k = 3
// Output: [[11,6],[11,4],[11,2]]
// Explanation: The first 3 pairs are returned from the sequence: [1,6],[1,4],[1,2],[7,6],[7,4],[11,6],[7,2],[11,4],[11,2]
// Example 2:
// Input: nums1 = [3,2], nums2 = [1, 4], k = 2
// Output: [[3,4],[3,1]]

import java.util.*;
public class kPairsOfLargestSums {
    public List<List<Integer>> kLargestPairs(int[] nums1, int[] nums2, int k) { // O(klogk) O(k)
        List<List<Integer>> result = new ArrayList<>();
        if(nums1.length == 0 || nums2.length == 0 || k == 0){
            return result;
        }
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> (b[0] + b[1]) - (a[0] + a[1]));
        for(int i = 0; i < nums1.length && i < k; i++){
            maxHeap.add(new int[]{nums1[i], nums2[0], 0});
        }
        while(k-- > 0 && !maxHeap.isEmpty()){
            int[] current = maxHeap.poll();
            result.add(List.of(current[0], current[1]));
            if(current[2] == nums2.length - 1){
                continue;
            }
            maxHeap.add(new int[]{current[0], nums2[current[2] + 1], current[2] + 1});
        }
        return result;
    }
    public int[] sum(int[] nums1, int[] nums2, int k) { // O(k log k), O(k)
        if (nums1.length == 0 || nums2.length == 0 || k == 0) return new int[]{};

        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> (b[0] + b[1]) - (a[0] + a[1]));
        int[] result = new int[Math.min(k, nums1.length * nums2.length) * 2];
        int index = 0;

        for (int i = 0; i < Math.min(nums1.length, k); i++) {
            maxHeap.add(new int[]{nums1[i], nums2[0], 0});
        }

        while (k-- > 0 && !maxHeap.isEmpty()) {
            int[] current = maxHeap.poll();
            result[index++] = current[0];
            result[index++] = current[1];

            if (current[2] + 1 < nums2.length) {
                maxHeap.add(new int[]{current[0], nums2[current[2] + 1], current[2] + 1});
            }
        }
        return Arrays.copyOf(result, index);
    }
}
