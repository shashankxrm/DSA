package BS;

//Problem Statement: Given a row-wise sorted matrix of size MXN, where M is no. of rows and
// N is no. of columns,
// find the median in the given matrix.

//Example:
//Input: M = 3, N = 3
//       matrix = [[1, 4, 9], [2, 5, 6], [3, 8, 7]]
//Output: 5
// Explanation: The median is 5.



public class medianOfRowWiseSortedMatrix {
    public int median(int matrix[][]){
        int m = matrix.length;
        int n = matrix[0].length;
        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;
        for(int i = 0; i < m; i++){
            low = Math.min(low, matrix[i][0]);
            high = Math.max(high, matrix[i][n - 1]);
        }
        int desired = (m * n + 1) / 2;
        while(low < high){
            int mid = low + (high - low) / 2;
            int count = 0;
            for(int i = 0; i < m; i++){
                count += countLessEqual(matrix[i], mid);
            }
            if(count < desired){
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    private int countLessEqual(int[] row, int target){
        int low = 0;
        int high = row.length;
        while(low < high){
            int mid = low + (high - low) / 2;
            if(row[mid] <= target){
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}
