package greedyAlgo;

//You are given three arrays: id, deadline, and profit, where each job is associated with an ID, a deadline, and a profit.
// Each job takes 1 unit of time to complete, and only one job can be scheduled at a time. You will earn the profit
// associated with a job only if it is completed by its deadline.
// Given id, deadline, and profit arrays, find the maximum profit you can earn by completing the jobs and also find the
// number of jobs you can complete.
// Example 1:
// Input: id = {1, 2, 3, 4, 5}, deadline = {4, 1, 1, 1, 1}, profit = {20, 10, 40, 30, 10}
// Output: [60, 2]
// Explanation: We can complete jobs 3 and 1, which will give us a total profit of 60.
// Example 2:
// Input: id = {1, 2, 3, 4, 5}, deadline = {2, 1, 2, 1, 3}, profit = {100, 19, 27, 25, 15}
// Output: [127, 3]
// Explanation: We can complete jobs 1, 3, and 4, which will give us a total profit of 127.


public class jobSequencing {
    public int[] jobScheduling(int[] id, int[] deadline, int[] profit) { // O(n^2) O(n)
        int n = id.length;
        int[] ans = new int[2];
        int maxProfit = 0;
        int count = 0;
        int[] jobs = new int[n];
        for(int i = 0; i < n; i++){
            jobs[i] = i;
        }
        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                if(profit[jobs[i]] < profit[jobs[j]]){
                    int temp = jobs[i];
                    jobs[i] = jobs[j];
                    jobs[j] = temp;
                }
            }
        }
        boolean[] slot = new boolean[n];
        for(int i = 0; i < n; i++){
            for(int j = Math.min(n, deadline[jobs[i]]) - 1; j >= 0; j--){
                if(!slot[j]){
                    slot[j] = true;
                    maxProfit += profit[jobs[i]];
                    count++;
                    break;
                }
            }
        }
        ans[0] = maxProfit;
        ans[1] = count;
        return ans;
    }
}
