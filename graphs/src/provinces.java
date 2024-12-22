// LC: 547. Number of Provinces
// There are n cities. Some of them are connected, while some are not. If city a is connected directly with
// city b, and city b is connected directly with city c, then city a is connected indirectly with city c.
// A province is a group of directly or indirectly connected cities and no other cities outside of the group.

// You are given an n x n matrix isConnected where isConnected[i][j] = 1 if the ith city and the jth city are
// directly connected, and isConnected[i][j] = 0 otherwise.
// return the total number of provinces.
//ex1 : Input: isConnected = [[1,1,0],[1,1,0],[0,0,1]]
// Output: 2
//ex2 : Input: isConnected = [[1,0,0],[0,1,0],[0,0,1]]
// Output: 3

import java.util.ArrayList;

public class provinces {
    public int findCircleNum(int[][] isConnected) { // time: O(n^2), space: O(n)
        int count = 0;
        int n = isConnected.length;
        boolean []visited = new boolean[n];
        for(int i=0; i<n; i++) {
            if(!visited[i]) {
                visit(i, isConnected, visited);
                count++;
            }
        }
        return count;
    }

    private void visit(int index, int [][]isConnected, boolean []visited) {
        visited[index] = true;
        for(int i=0; i<isConnected.length; i++) {
            if(!visited[i] && isConnected[index][i] != 0) {
                visit(i, isConnected, visited);
            }
        }
    }
}
