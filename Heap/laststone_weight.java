
/*
 * LeetCode 1046 - Last Stone Weight
 *
 * QUESTION:
 * You are given an array of integers called stones, where each
 * integer represents the weight of a stone.
 *
 * Each turn, choose the two heaviest stones and smash them together:
 *
 * 1. If both stones have the same weight, both stones are destroyed.
 * 2. If they have different weights, the smaller stone is destroyed,
 *    and the larger stone is replaced with the difference in their weights.
 *
 * Repeat this process until at most one stone remains.
 *
 * Return the weight of the last remaining stone.
 * If no stones remain, return 0.
 *
 *
 * APPROACH: MAX HEAP
 *
 * - Use a Max Heap to always retrieve the two heaviest stones.
 * - Remove the two largest elements using poll().
 * - Calculate their difference.
 * - If the difference is greater than 0, insert it back into the heap.
 * - Repeat until fewer than two stones remain.
 */

class Solution {
    public int lastStoneWeight(int[] stones) {

        // Create a Max Heap (largest element stays at the top)
        PriorityQueue<Integer> pq =
            new PriorityQueue<>(Collections.reverseOrder());

        // Insert all stone weights into the Max Heap
        for (int stone : stones) {
            pq.offer(stone);
        }

        // Continue while at least two stones are available
        while (pq.size() > 1) {

            // Extract the two heaviest stones
            int first = pq.poll();
            int second = pq.poll();

            // Calculate the remaining weight after smashing
            int diff = first - second;

            // Insert the remaining stone if the weights differ
            if (diff > 0) {
                pq.offer(diff);
            }
        }

        // Return the last stone's weight, or 0 if heap is empty
        return pq.isEmpty() ? 0 : pq.poll();
    }
}

/*
 * TIME COMPLEXITY:
 * O(n log n)
 * Each insertion and removal takes O(log n).
 *
 * SPACE COMPLEXITY:
 * O(n)
 * The Max Heap stores up to n stones.
 */
