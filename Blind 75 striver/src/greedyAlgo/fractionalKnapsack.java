package greedyAlgo;

// Problem Statement: The weight of N items and their corresponding values are given. We have to put these items in a
// knapsack of weight W such that the total value obtained is maximized.
//Note: We can either take the item as a whole or break it into smaller units.
// Example 1:
// Input:
// N = 3, W = 50
// values[] = {60,100,120}
// weight[] = {10,20,30}
// Output: 240.00
// Explanation: The first and second items  are taken as a whole  while only 20 units of the third item is taken.
// Total value = 100 + 60 + 80 = 240.00

public class fractionalKnapsack {
    public double fractionalKnapsack(int W, Item arr[], int n) { // O(nlogn) O(1)
        java.util.Arrays.sort(arr, (a, b) -> Double.compare(b.value * 1.0 / b.weight, a.value * 1.0 / a.weight));
        double ans = 0;
        for (Item item : arr) {
            if (item.weight <= W) {
                ans += item.value;
                W -= item.weight;
            } else {
                ans += item.value * 1.0 * W / item.weight;
                break;
            }
        }
        return ans;
    }

    static class Item {
        int value, weight;

        Item(int x, int y) {
            this.value = x;
            this.weight = y;
        }
    }
}
