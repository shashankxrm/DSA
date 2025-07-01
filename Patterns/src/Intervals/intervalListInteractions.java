package Intervals;

// LC986: Interval List Intersections
// Given two lists of closed intervals firstList and secondList, return the intersection of these two interval lists.
// A closed interval [a, b] (with a <= b) denotes the set of real numbers x with a <= x <= b.
// The intersection of two closed intervals [a, b] and [c, d] is a closed interval [max(a, c), min(b, d)] if it is non-empty,
// and the intersection is empty otherwise.
// Example 1: Input: firstList = [[0,2],[5,10],[13,23],[24,25]], secondList = [[1,5],[8,12],[15,24],[25,26]]
// Output: [[1,2],[5,5],[15,23],[24,24]]
public class intervalListInteractions {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) { // Time: O(n + m), Space: O(n + m)
        java.util.List<int[]> result = new java.util.ArrayList<>();
        int i = 0, j = 0;
        while (i < firstList.length && j < secondList.length) {
            // Find the intersection of firstList[i] and secondList[j]
            int start = Math.max(firstList[i][0], secondList[j][0]);
            int end = Math.min(firstList[i][1], secondList[j][1]);
            if (start <= end) { // If there is an intersection
                result.add(new int[]{start, end});
            }
            // Move to the next interval in the list that ends first
            if (firstList[i][1] < secondList[j][1]) {
                i++;
            } else {
                j++;
            }
        }
        return result.toArray(new int[result.size()][]); // Convert list to array and return
    }
}
