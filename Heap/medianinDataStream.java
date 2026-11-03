
import java.util.PriorityQueue;

class MedianFinder {

    // Max Heap: stores the smaller half of numbers
    private PriorityQueue<Integer> maxHeap;

    // Min Heap: stores the larger half of numbers
    private PriorityQueue<Integer> minHeap;

    public MedianFinder() {

        // Reverse natural ordering to create Max Heap
        maxHeap = new PriorityQueue<>(
            (a, b) -> Integer.compare(b, a)
        );

        // Default PriorityQueue is a Min Heap
        minHeap = new PriorityQueue<>();
    }

    public void addNum(int num) {

        // Step 1: Insert into the appropriate heap
        if (maxHeap.isEmpty() || num <= maxHeap.peek()) {
            maxHeap.offer(num);
        } else {
            minHeap.offer(num);
        }

        // Step 2: Balance both heaps
        // Max Heap can have at most one extra element
        if (maxHeap.size() > minHeap.size() + 1) {
            minHeap.offer(maxHeap.poll());
        }
        else if (minHeap.size() > maxHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }
    }

    public double findMedian() {

        // Even number of elements: average of both roots
        if (maxHeap.size() == minHeap.size()) {
            return maxHeap.peek() / 2.0
                 + minHeap.peek() / 2.0;
        }

        // Odd number of elements: root of Max Heap
        return maxHeap.peek();
    }
}
