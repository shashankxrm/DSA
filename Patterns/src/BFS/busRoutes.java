package BFS;
import java.util.*;
// LC815: Bus Routes
// You are given an array routes representing bus routes where routes[i] is a bus route that the ith bus repeats forever.
// You will start at the bus stop source (0-indexed) and you want to go to the bus stop target (0-indexed).
// Return the least number of buses you must take to travel from source to target. If it is not possible, return -1.
// Example 1: Input: routes = [[1,2,7],[3,6,7]], source = 1, target = 6 Output: 2
public class busRoutes {
    public int numBusesToDestination(int[][] routes, int source, int target) { // Time: O(n^2), Space: O(n)
        if (source == target) return 0; // Already at the target
        Map<Integer, List<Integer>> stopToRoutes = new HashMap<>();
        for (int i = 0; i < routes.length; i++) {
            for (int stop : routes[i]) {
                stopToRoutes.putIfAbsent(stop, new ArrayList<>());
                stopToRoutes.get(stop).add(i);
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visitedStops = new HashSet<>();
        Set<Integer> visitedRoutes = new HashSet<>();
        queue.offer(source);
        visitedStops.add(source);
        int buses = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            buses++;
            for (int i = 0; i < size; i++) {
                int currentStop = queue.poll();
                for (int route : stopToRoutes.getOrDefault(currentStop, Collections.emptyList())) {
                    if (visitedRoutes.contains(route)) continue; // Skip already visited routes
                    visitedRoutes.add(route);
                    for (int nextStop : routes[route]) {
                        if (nextStop == target) return buses; // Found the target
                        if (!visitedStops.contains(nextStop)) {
                            visitedStops.add(nextStop);
                            queue.offer(nextStop);
                        }
                    }
                }
            }
        }
        return -1; // Target not reachable
    }
}
