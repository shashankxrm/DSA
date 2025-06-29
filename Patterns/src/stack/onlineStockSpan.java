package stack;

// LC901: Online Stock Span
// Design an algorithm that collects daily price quotes for some stock and returns the span of that stock's price for
// the current day.The span of the stock's price today is defined as the maximum number of consecutive days (starting
// from today and going backwards) for which the price of the stock was less than or equal to today's price.
// For example, if the price of a stock over the next 7 days is [100, 80, 60, 70, 60, 75, 85], then the stock spans are
// [1, 1, 1, 2, 1, 4, 6].
// Example 1: Input: prices = [100,80,60,70,60,75,85] Output: [1,1,1,2,1,4,6]
// Example 2: Input: prices = [100, 90, 80, 70, 60] Output: [1, 1, 1, 1, 1]
public class onlineStockSpan {
    private java.util.Stack<int[]> stack; // Stack to store price and its span
    public onlineStockSpan() { // Constructor initializes the stack
        stack = new java.util.Stack<>();
    }
    public int next(int price) { // Method to calculate the span for the given price
        int span = 1; // Start with a span of 1 for the current price
        while (!stack.isEmpty() && stack.peek()[0] <= price) { // While the top of the stack has a price less than or equal to current price
            span += stack.pop()[1]; // Add the span of that price to current span
        }
        stack.push(new int[]{price, span}); // Push the current price and its calculated span onto the stack
        return span; // Return the calculated span
    }

}
