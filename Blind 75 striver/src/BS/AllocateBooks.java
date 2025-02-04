package BS;

// LC 410 : Allocate Minimum Number of Pages
// You are given n books. Some of the books are assigned to a student, and each book is assigned to exactly one student.
// A book will be allocated to a student if the sum of the pages in the books assigned to a student does not exceed the
// maximum number of pages a student can read. The goal is to assign the books in such a way that the maximum number of
// pages assigned to a student is minimized.
// You are given an integer array pages, where pages[i] is the number of pages of the ith book, and an integer k.
// You should distribute the books to k students so that the maximum number of pages assigned to a student is minimized.
// Return the minimum of the maximum number of pages assigned to a student.
// Example 1:
// Input: pages = [12,34,67,90], k = 2
// Output: 113
// Explanation: There are 2 students. Books can be distributed in the following way:
// 1st student: 12, 34, 67 (total = 113)
// 2nd student: 90 (total = 90)
// The maximum number of pages assigned to a student is 113.
// Example 2:
// Input: pages = [3,2,4], k = 2
// Output: 5
// Explanation: 2 students can read the books as follows:
// 1st student: 3, 2 (total = 5)
// 2nd student: 4 (total = 4)
// The maximum number of pages assigned to a student is 5.
// Example 3:
// Input: pages = [7,2,5,10,8], k = 2
// Output: 18

import java.util.*;

public class AllocateBooks {
    public int minPages(int[] pages, int k) { // O(nlogn) O(1)
        if(pages.length < k){
            return -1;
        }
        int low = 0;
        int high = 0;
        for(int page : pages){
            low = Math.max(low, page);
            high += page;
        }
        int result = -1;
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(isPossible(pages, k, mid)){
                result = mid;
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return result;
    }

    private boolean isPossible(int[] pages, int k, int mid){
        int students = 1;
        int sum = 0;
        for(int page : pages){
            sum += page;
            if(sum > mid){
                students++;
                sum = page;
            }
        }
        return students <= k;
    }
}
