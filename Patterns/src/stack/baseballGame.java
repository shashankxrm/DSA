package stack;

// LC682: Baseball Game
// You're now playing the baseball game, where the game consists of several rounds, and in each round, you can record
// one of the following three types of scores:
// 1. An integer x (x > 0) - Record a new score of x.
// 2. "+" - Record a new score that is the sum of the previous two scores.
// 3. "D" - Record a new score that is double the previous score.
// 4. "C" - Invalidate the previous score, removing it from the record.
// You need to return the sum of all the scores recorded.
// Example 1: Input: ops = ["5","2","C","D","+"] Output: 30 Explanation: The operations are as follows:
// - "5" - Add 5 to the record. Record: [5].
// - "2" - Add 2 to the record. Record: [5, 2].
// - "C" - Invalidate the previous score, removing 2. Record: [5].
// - "D" - Add a new score that is double the previous score, which is 5 * 2 = 10. Record: [5, 10].
// - "+" - Add a new score that is the sum of the previous two scores, which is 5 + 10 = 15. Record: [5, 10, 15].
// The sum of the scores is 5 + 10 + 15 = 30.
public class baseballGame {
    public int calPoints(String[] ops) { // Time: O(n), Space: O(n)
        java.util.Stack<Integer> stack = new java.util.Stack<>();
        for (String op : ops) {
            if (op.equals("C")) {
                stack.pop(); // Remove the last score
            } else if (op.equals("D")) {
                stack.push(stack.peek() * 2); // Double the last score
            } else if (op.equals("+")) {
                int top1 = stack.pop(); // Get the last score
                int top2 = stack.peek(); // Get the second last score
                stack.push(top1); // Push back the last score
                stack.push(top1 + top2); // Push the sum of the last two scores
            } else {
                stack.push(Integer.parseInt(op)); // Push the integer score
            }
        }
        return stack.stream().mapToInt(Integer::intValue).sum(); // Return the sum of all scores
    }
}
