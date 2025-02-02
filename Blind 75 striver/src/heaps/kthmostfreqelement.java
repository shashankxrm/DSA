package heaps;

// LC # 347 : Top K Frequent Elements
// Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.
// Example 1:
// Input: nums = [1,1,1,2,2,3], k = 2
// Output: [1,2]
// Example 2:
// Input: nums = [1], k = 1
// Output: [1]


public class kthmostfreqelement {
    // bucket approach
    public int[] topKFrequent(int[] nums, int k) { // time : O(n), space : O(n)
        java.util.Map<Integer, Integer> map = new java.util.HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        java.util.List<Integer>[] bucket = new java.util.List[nums.length + 1];
        for (int key : map.keySet()) {
            int frequency = map.get(key);
            if (bucket[frequency] == null) {
                bucket[frequency] = new java.util.ArrayList<>();
            }
            bucket[frequency].add(key);
        }
        int[] res = new int[k];
        int index = 0;
        for (int i = bucket.length - 1; i >= 0 && index < k; i--) {
            if (bucket[i] != null) {
                for (int num : bucket[i]) {
                    res[index++] = num;
                    if (index == k) {
                        break;
                    }
                }
            }
        }
        return res;
    }


}
