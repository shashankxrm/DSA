package BFS;
import java.util.*;
// LC841: Keys and Rooms
// There are n rooms labeled from 0 to n - 1 and all the rooms are locked except for room 0. Your goal is to visit all
// the rooms. However, you cannot enter a locked room unless you have its key. When you visit a room, you may find a
// key in it. Each key has a number on it, denoting which room it unlocks, and you can only unlock one room with each key.
// Given an array of lists rooms where rooms[i] is the list of keys that you can obtain if you visited room i, return true
// if you can visit all the rooms, or false otherwise.
// Example 1: Input: rooms = [[1],[2],[3],[]] Output: true Explanation: You can visit all the rooms.
public class keysandrooms {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) { // Time: O(n), Space: O(n)
        int n = rooms.size(); // bfs solution
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0); // Start from room 0
        visited[0] = true;
        while (!queue.isEmpty()) {
            int room = queue.poll();
            for (int key : rooms.get(room)) {
                if (!visited[key]) {
                    visited[key] = true;
                    queue.offer(key);
                }
            }
        }
        // Check if all rooms are visited
        for (boolean v : visited) {
            if (!v) return false;
        }
        return true;
    }
    // dfs solution
    public boolean canVisitAllRoomsDFS(List<List<Integer>> rooms) { // Time: O(n), Space: O(n)
        int n = rooms.size();
        boolean[] visited = new boolean[n];
        dfs(rooms, 0, visited);
        for (boolean v : visited) {
            if (!v) return false;
        }
        return true;
    }
    private void dfs(List<List<Integer>> rooms, int room, boolean[] visited) {
        visited[room] = true; // Mark the current room as visited
        for (int key : rooms.get(room)) {
            if (!visited[key]) {
                dfs(rooms, key, visited); // Visit the room that can be unlocked with the key
            }
        }
    }
}
