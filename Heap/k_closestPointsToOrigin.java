import java.util.*;

class Solution {

    public int[][] kClosest(int[][] points, int k) {

        // Max Heap: point with the largest distance stays at the top
        // Each entry stores {squaredDistance, x, y}
        PriorityQueue<long[]> heap = new PriorityQueue<>(
            (a, b) -> Long.compare(b[0], a[0])
        );

        // Process every point
        for (int[] point : points) {

            int x = point[0];
            int y = point[1];

            // Calculate squared distance from origin
            // Cast to long before multiplication to avoid integer overflow
            long distance = (long) x * x + (long) y * y;

            // Insert {distance, x, y} into the Max Heap
            heap.offer(new long[]{distance, x, y});

            // Maintain heap size K
            if (heap.size() > k) {

                // Remove the farthest point (root of Max Heap)
                heap.poll();
            }
        }

        // Store the K closest points
        int[][] result = new int[k][2];

        // Extract remaining K points from the heap
        for (int i = 0; i < k; i++) {

            long[] current = heap.poll();

            result[i][0] = (int) current[1]; // x coordinate
            result[i][1] = (int) current[2]; // y coordinate
        }

        return result;
    }
}