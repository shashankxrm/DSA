package dp;

// LC 39 : Combination Sum
// Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations
// of candidates where the chosen numbers sum to target.
// You may return the combinations in any order.
// The same number may be chosen from candidates an unlimited number of times.
// Two combinations are unique if the frequency of at least one of the chosen numbers is different.
// It is guaranteed that the number of unique combinations that sum up to target is less than 150 combinations for the given input.
// Example 1:
// Input: candidates = [2,3,6,7], target = 7
// Output: [[2,2,3],[7]]
// Input: candidates = [2,3,5], target = 8
// Output: [[2,2,2,2],[2,3,3],[3,5]]
import java.util.ArrayList;
import java.util.List;

public class combinationSum {
    public static void main(String[] args) {
        int[] candidates = {2,3,6,7};
        int target = 7;
        System.out.println(combinationSum(candidates,target));
    }

    public static void sum(int i, int[] arr, List<List<Integer>> list, List<Integer> ds,int target){
        if(i==arr.length){
            if(target==0){
                list.add(new ArrayList<>(ds));
            }
            return;
        }
        if(arr[i]<=target){
            ds.add(arr[i]);
            sum(i,arr,list,ds,target-arr[i]);
            ds.remove(ds.size()-1);
        }
        sum(i+1, arr, list, ds, target);
    }
    static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list= new ArrayList<>();
        sum(0,candidates,list,new ArrayList<>(),target);
        return list;

    }

}
