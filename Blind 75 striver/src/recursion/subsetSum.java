package recursion;

// Given a array arr of integers, return the sums of all subsets in the list.  Return the sums in any order.
// Example 1:
// Input: arr = [1, 2, 3]
// Output: [0, 1, 2, 3, 3, 4, 5, 6]
// Explanation: The resulting sums are: 0, 1, 2, 3, 3, 4, 5, 6
// Example 2:
// Input: arr = [1, 2, 1]
// Output: [0, 1, 1, 2, 2, 3, 3, 4]

public class subsetSum {
    public java.util.List<Integer> subsetSums(java.util.List<Integer> arr, int N){
        java.util.List<Integer> result = new java.util.ArrayList<>();
        helper(arr, N, 0, 0, result);
        return result;
    }

    private void helper(java.util.List<Integer> arr, int N, int index, int sum, java.util.List<Integer> result){
        if(index == N){
            result.add(sum);
            return;
        }
        helper(arr, N, index + 1, sum + arr.get(index), result);
        helper(arr, N, index + 1, sum, result);
    }
}
