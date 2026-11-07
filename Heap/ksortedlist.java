
import java.util.PriorityQueue;

class Solution {

    public ListNode mergeKLists(ListNode[] lists) {

        // Min Heap: smallest node value stays at the root
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(
            (a, b) -> Integer.compare(a.val, b.val)
        );

        // Add the head of every non-empty linked list
        for (ListNode node : lists) {
            if (node != null) {
                minHeap.offer(node);
            }
        }

        // Dummy node simplifies building the merged list
        ListNode dummyNode = new ListNode(0);
        ListNode curr = dummyNode;

        // Process nodes in ascending order
        while (!minHeap.isEmpty()) {

            // Extract the smallest available node
            ListNode node = minHeap.poll();

            // Attach it to the merged list
            curr.next = node;
            curr = curr.next;

            // Add the next node from the same list
            if (node.next != null) {
                minHeap.offer(node.next);
            }
        }

        return dummyNode.next;
    }
}
