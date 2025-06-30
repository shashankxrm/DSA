package topKelements;
import java.util.*;

// LC658: Find K Closest Elements
// Given a sorted integer array arr, two integers k and x, return the k closest integers to x in the array. The result
// should also be sorted in ascending order. An integer a is closer to x than an integer b if:
// |a - x| < |b - x|, or |a - x| == |b - x| and a < b.
// Example 1: Input: arr = [1,2,3,4,5], k = 4, x = 3 Output: [1,2,3,4]
// Example 2: Input: arr = [1,2,3,4,5], k = 4, x = -1 Output: [1,2,3,4]
public class findKclosestEle {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int left = 0, right = arr.length - 1;

        while (right - left >= k) {
            if (Math.abs(arr[left] - x) > Math.abs(arr[right] - x)) {
                left++;
            } else {
                right--;
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int i = left; i < left + k; i++) {
            result.add(arr[i]);
        }

        return result;
    }
}
