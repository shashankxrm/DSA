package heaps;

// LC 373 : Find K Pairs with Smallest Sums
// You are given two integer arrays nums1 and nums2 sorted in non-decreasing order and an integer k.
// Define a pair (u,v) which consists of one element from the first array and one element from the second array.
// Find the k pairs (u1,v1),(u2,v2) ...(uk,vk) with the smallest sums.
// Example 1:
// Input: nums1 = [1,7,11], nums2 = [2,4,6], k = 3
// Output: [[1,2],[1,4],[1,6]]
// Explanation: The first 3 pairs are returned from the sequence: [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]
// Example 2:
// Input: nums1 = [1,1,2], nums2 = [1,2,3], k = 2
// Output: [[1,1],[1,1]]
// Explanation: The first 2 pairs are returned from the sequence: [1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[2,3]

import java.util.*;

public class kPairsOfSmallestSums {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) { // O(klogk) O(k)
        List<List<Integer>> result = new ArrayList<>();
        if(nums1.length == 0 || nums2.length == 0 || k == 0){
            return result;
        }
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> (a[0] + a[1]) - (b[0] + b[1]));
        for(int i = 0; i < nums1.length && i < k; i++){
            minHeap.add(new int[]{nums1[i], nums2[0], 0});
        }
        while(k-- > 0 && !minHeap.isEmpty()){
            int[] current = minHeap.poll();
            result.add(List.of(current[0], current[1]));
            if(current[2] == nums2.length - 1){
                continue;
            }
            minHeap.add(new int[]{current[0], nums2[current[2] + 1], current[2] + 1});
        }
        return result;
    }


}
