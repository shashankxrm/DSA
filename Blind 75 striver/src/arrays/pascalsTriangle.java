package arrays;

// LC 118 : Pascal's Triangle
// Given an integer numRows, return the first numRows of Pascal's triangle.
// In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:
// Example 1:
// Input: numRows = 5
// Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]

import java.util.ArrayList;
import java.util.List;

public class pascalsTriangle {
    static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        if (numRows == 0) {
            return null;
        }
        if (numRows == 1) {
            List<Integer> row = new ArrayList<>();
            row.add(1);
            ans.add(row);
            return ans;
        }
        for (int i = 0; i < numRows ; i++) {
            List<Integer> ithrow = new ArrayList<>();
            for (int j = 0; j <=i ; j++) {
                 if(j == 0 || j == i){
                     ithrow.add(1);
                 } else {
                     ithrow.add(ans.get(i - 1).get(j - 1) + ans.get(i - 1).get(j));
                 }
            }
            ans.add(ithrow);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(generate(5));
    }
}
