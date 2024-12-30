package greedyAlgo;

// LC 452 : Minimum Number of Platforms Required for a Railway/Bus Station
// Given arrival and departure times of all trains that reach a railway station, the task is to find the minimum number
// of platforms required for the railway station so that no train waits.
// We are given two arrays which represent arrival and departure times of trains that stop.
// Example 1:
// Input: n = 6, arr[] = {0900, 0940, 0950, 1100, 1500, 1800}, dep[] = {0910, 1200, 1120, 1130, 1900, 2000}
// Output: 3
// Explanation: Minimum 3 platforms are required to safely arrive and depart all trains.
// Example 2:
// Input: n = 3, arr[] = {0900, 1100, 1235}, dep[] = {1000, 1200, 1240}
// Output: 1
// Explanation: Only 1 platform is required to safely arrive and depart all trains.

public class minNumofPlatforms {
    public static int findPlatform(int arr[], int dep[], int n) { // O(nlogn) O(1)
        java.util.Arrays.sort(arr);
        java.util.Arrays.sort(dep);
        int i = 1, j = 0, res = 1, plat = 1;
        while (i < n && j < n) {
            if (arr[i] <= dep[j]) {
                plat++;
                i++;
            } else if (arr[i] > dep[j]) {
                plat--;
                j++;
            }
            res = Math.max(res, plat);
        }
        return res;
    }
}
