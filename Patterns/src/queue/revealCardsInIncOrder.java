package queue;

// LC950: Reveal Cards in Increasing Order
// In a deck of cards, each card has a unique integer. You can order the deck in any order you like.
// Initially, all the cards start face down (unrevealed) in one deck. You will do the following steps repeatedly until
// all cards are revealed:
// 1. Take the top card of the deck, reveal it, and take it out of the deck.
// 2. If there are still cards in the deck, put the next top card of the deck at the bottom of the deck.
// 3. If there are still unrevealed cards, go back to step 1.
// Given the deck of cards `deck`, return an array of the cards in the order they are revealed.
// Example 1: Input: deck = [17,13,11,2,3,5,7] Output: [2,13,3,11,5,17,7]
// Example 2: Input: deck = [1,1000] Output: [1,1000]
public class revealCardsInIncOrder {
    public int[] deckRevealedIncreasing(int[] deck) { // Time: O(n log n), Space: O(n)
        int n = deck.length; int[] result = new int[n];
        java.util.Arrays.sort(deck); // Sort the deck in increasing order
        java.util.Queue<Integer> queue = new java.util.LinkedList<>();
        for (int i = 0; i < n; i++) {
            queue.offer(i); // Fill the queue with indices
        }
        for (int card : deck) {
            result[queue.poll()] = card; // Place the card in the correct position
            if (!queue.isEmpty()) {
                queue.offer(queue.poll()); // Move the next index to the back of the queue
            }
        }
        return result; // Return the final order of revealed cards
    }
}
