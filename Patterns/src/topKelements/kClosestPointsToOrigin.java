package topKelements;

// LC973: K Closest Points to Origin
// Given an array of points where points[i] = [xi, yi] represents a point on the X-Y plane and an integer k, return the
// k closest points to the origin (0, 0). The distance between two points on the X-Y plane is the Euclidean distance, so
// the distance to the origin is sqrt(xi^2 + yi^2). You may return the answer in any order. The answer is guaranteed to
// be unique (except for the order that it is in).
//Example 1: Input: points = [[1,3],[-2,2]], k = 1 Output: [[-2,2]]
public class kClosestPointsToOrigin {
    public int[][] kClosest(int[][] points, int k) { // Time: O(n log k), Space: O(n)
        java.util.PriorityQueue<int[]> maxHeap = new java.util.PriorityQueue<>(
            (a, b) -> Integer.compare(b[0] * b[0] + b[1] * b[1], a[0] * a[0] + a[1] * a[1]) // Max-heap based on distance
        );
        for (int[] point : points) {
            maxHeap.offer(point); // Add to heap
            if (maxHeap.size() > k) {
                maxHeap.poll(); // Maintain size of heap to k
            }
        }
        int[][] result = new int[k][2];
        for (int i = 0; i < k; i++) {
            result[i] = maxHeap.poll(); // Extract the k closest points
        }
        return result; // Return the result array
    }
}
