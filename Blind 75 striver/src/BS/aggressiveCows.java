package BS;

//Problem Statement: You are given an array 'arr' of size 'n' which denotes the position of stalls.
//You are also given an integer 'k' which denotes the number of aggressive cows.
//You are given the task of assigning stalls to 'k' cows such that the minimum distance between any two of them is the maximum possible.
//Find the maximum possible minimum distance.

//Example:
//Input: arr = [1, 2, 4, 8, 9], k = 3
//Output: 3
//Explanation: The stalls can be assigned as [1, 4, 8] to the 3 cows. The minimum distance between any two cows is 3.

import java.util.*;

public class aggressiveCows {
    public int maxMinDistance(int[] arr, int k) { // O(nlogn) O(1)
        Arrays.sort(arr);
        int low = 1;
        int high = arr[arr.length - 1] - arr[0];
        int result = -1;
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(isPossible(arr, k, mid)){
                result = mid;
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        return result;
    }

    private boolean isPossible(int[] arr, int k, int mid){
        int cows = 1;
        int prev = arr[0];
        for(int i = 1; i < arr.length; i++){
            if(arr[i] - prev >= mid){
                cows++;
                prev = arr[i];
            }
        }
        return cows >= k;
    }
}
