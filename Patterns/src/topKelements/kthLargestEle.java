package topKelements;

// LC215: Kth Largest Element in an Array. Find the kth largest element in an unsorted array. Note that it is the kth
// largest element in the sorted order, not the kth distinct element.Example 1: Input: nums = [3,2,1,5,6,4], k = 2 Output: 5
public class kthLargestEle {
    public int findKthLargest(int[] nums, int k) { // Time: O(n) on average, Space: O(1) for QuickSelect.
        int targetIdx = nums.length - k;
        return quickSelect(nums, 0, nums.length - 1, targetIdx);
    }
    private int quickSelect(int[] nums, int left, int right, int targetIdx) {
        if (left == right) {
            return nums[left];
        }
        int pivot = nums[left];
        int low = left;
        int high = right;
        while (low <= high) {
            while (low <= high && nums[low] < pivot) {
                low++;
            }
            while (low <= high && nums[high] > pivot) {
                high--;
            }
            if (low <= high) {
                int temp = nums[low];
                nums[low] = nums[high];
                nums[high] = temp;
                low++;
                high--;
            }
        }
        if (targetIdx <= high) {
            return quickSelect(nums, left, high, targetIdx);
        } else if (targetIdx >= low) {
            return quickSelect(nums, low, right, targetIdx);
        } else {
            return nums[targetIdx];
        }
    }
}
