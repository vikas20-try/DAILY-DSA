class Solution {
    public int findKthLargest(int[] nums, int k) {

        // Create a Min Heap
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // Traverse through every element in the array
        for (int i = 0; i < nums.length; i++) {

            // Add the current element to the Min Heap
            minHeap.add(nums[i]);

            // Maintain the heap size as K
            if (minHeap.size() > k) {

                // Remove the smallest element
                // This ensures that only the K largest elements remain
                minHeap.poll();
            }
        }

        // The root of the Min Heap is the Kth largest element
        return minHeap.poll();
    }
}