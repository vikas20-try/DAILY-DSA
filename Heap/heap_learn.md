# Heaps (Data Structures)

A **heap** is a tree-based data structure used to quickly access the
smallest or largest element. Heaps are commonly used to implement
**priority queues** and solve problems involving top `K` elements,
scheduling, and merging sorted data.

## 1. How a Heap Works

A binary heap is a **complete binary tree**:

-   Every level is completely filled, except possibly the last.
-   The last level is filled from left to right.
-   Every parent follows a specific ordering rule relative to its
    children.

There are two common types:

### Min Heap

The parent is always **less than or equal to** its children. The
smallest element is at the root.

``` text
        2
       / \
      5   4
     / \
    9   7
```

### Max Heap

The parent is always **greater than or equal to** its children. The
largest element is at the root.

``` text
        9
       / \
      7   5
     / \
    2   4
```

**Important:** A heap is not a fully sorted tree. Only the root is
guaranteed to be the minimum (Min Heap) or maximum (Max Heap).

## 2. How a Heap Is Stored

A binary heap is usually stored in an array. For a node at index `i`
(using zero-based indexing):

  Relationship        Array index
  -------------- ----------------
  Parent           `(i - 1) // 2`
  Left child          `2 * i + 1`
  Right child         `2 * i + 2`

For example, this Min Heap:

``` text
        2
       / \
      5   4
     / \
    9   7
```

Is stored as:

``` python
[2, 5, 4, 9, 7]
```

## 3. The Two Main Heap Operations

### Insertion --- Heapify Up

1.  Add the new value at the end of the array.
2.  Compare it with its parent.
3.  If the heap property is violated, swap the two values.
4.  Continue moving up until the property is restored or the value
    reaches the root.

### Removal --- Heapify Down

In a Min Heap, removing the root works like this:

1.  Save the root value.
2.  Move the last element to the root and remove the last array
    position.
3.  Compare the new root with its children.
4.  Swap it with the smaller child if necessary.
5.  Continue moving down until the Min Heap property is restored.

A Max Heap follows the same process, but swaps with the larger child.

## 4. Time and Space Complexity

Let `N` be the number of elements in the heap.

  Operation                                Time complexity
  -------------------------------------- -----------------
  Peek at root                                      `O(1)`
  Insert                                        `O(log N)`
  Remove root                                   `O(log N)`
  Build heap from an array (`heapify`)              `O(N)`
  Search for an arbitrary value                     `O(N)`

A heap stores `N` elements, so its space complexity is `O(N)`.

## 5. Heap in Python (`heapq`)

Python's `heapq` module provides a Min Heap by default.

### Min Heap

``` python
import heapq

heap = []

heapq.heappush(heap, 30)
heapq.heappush(heap, 10)
heapq.heappush(heap, 20)

print(heap[0])               # 10: smallest element
print(heapq.heappop(heap))   # 10: remove and return smallest
print(len(heap))             # 2: current heap size
```

Useful operations:

``` python
heapq.heappush(heap, value)  # Insert
heapq.heappop(heap)          # Remove and return smallest
heap[0]                      # Read smallest without removing it
len(heap)                    # Number of elements
heapq.heapify(values)        # Convert a list into a heap in O(N)
```

### Max Heap in Python

A common approach is to store negative values. The most negative value
represents the largest original number.

``` python
import heapq

max_heap = []

heapq.heappush(max_heap, -30)
heapq.heappush(max_heap, -10)
heapq.heappush(max_heap, -50)

print(-max_heap[0])                 # 50: largest original value
print(-heapq.heappop(max_heap))     # 50: remove largest original value
```

When using this technique, remember to negate values when inserting and
when reading/removing them.

## 6. Heap in Java (`PriorityQueue`)

Java's `PriorityQueue` is a Min Heap by default.

``` java
import java.util.PriorityQueue;
import java.util.Collections;

PriorityQueue<Integer> minHeap = new PriorityQueue<>();

minHeap.add(30);
minHeap.add(10);
minHeap.add(20);

System.out.println(minHeap.peek()); // 10
System.out.println(minHeap.poll()); // Removes and returns 10
System.out.println(minHeap.size()); // 2
```

For a Max Heap, use a reverse-order comparator:

``` java
PriorityQueue<Integer> maxHeap =
    new PriorityQueue<>(Collections.reverseOrder());

maxHeap.add(30);
maxHeap.add(10);
maxHeap.add(50);

System.out.println(maxHeap.peek()); // 50
System.out.println(maxHeap.poll()); // Removes and returns 50
```

## 7. A Classic Heap Problem: Kth Largest Element

**Problem:** Find the `k`th largest element in an array.

**Idea:** Keep a Min Heap containing only the `k` largest values seen so
far.

1.  Insert each number into the Min Heap.
2.  If the heap size becomes greater than `k`, remove the smallest
    value.
3.  After processing every number, the root is the `k`th largest value.

Python solution:

``` python
import heapq

def find_kth_largest(nums, k):
    min_heap = []

    for num in nums:
        heapq.heappush(min_heap, num)

        # Keep only the k largest elements
        if len(min_heap) > k:
            heapq.heappop(min_heap)

    # The smallest of the k largest values is the kth largest
    return min_heap[0]


print(find_kth_largest([3, 2, 1, 5, 6, 4], 2))  # 5
```

**Complexity:**

-   Time: `O(N log K)`
-   Extra space: `O(K)`

Why does this work? Once the heap contains `k` elements, its root is the
smallest among the `k` largest values retained. That value is exactly
the `k`th largest element.

## 8. When Should You Use a Heap?

Look for a heap when a problem asks you to:

-   Find the smallest or largest item repeatedly.
-   Find the top `K` largest, smallest, or most frequent items.
-   Process tasks by priority.
-   Merge multiple sorted lists or arrays.
-   Find a running median using two heaps.
-   Keep a fixed-size collection of the best candidates.

## 9. Practice Problems

  -------------------------------------------------------------------------------------------------------------
  Problem                                                                   Main idea
  ------------------------------------------------------------------------- -----------------------------------
  [215. Kth Largest Element in an                                           Min Heap of size `K`
  Array](https://leetcode.com/problems/kth-largest-element-in-an-array/)    

  [703. Kth Largest Element in a                                            Maintain a Min Heap of size `K`
  Stream](https://leetcode.com/problems/kth-largest-element-in-a-stream/)   

  [347. Top K Frequent                                                      Hash Map + Heap
  Elements](https://leetcode.com/problems/top-k-frequent-elements/)         

  [973. K Closest Points to                                                 Heap / Top `K`
  Origin](https://leetcode.com/problems/k-closest-points-to-origin/)        

  [295. Find Median from Data                                               Two Heaps
  Stream](https://leetcode.com/problems/find-median-from-data-stream/)      

  [23. Merge k Sorted                                                       Min Heap
  Lists](https://leetcode.com/problems/merge-k-sorted-lists/)               
  -------------------------------------------------------------------------------------------------------------

## Quick Revision

``` text
MIN HEAP
- Root = smallest element
- Python: heapq (default)
- Java: PriorityQueue (default)

MAX HEAP
- Root = largest element
- Python: store negative values (common technique)
- Java: PriorityQueue with reverseOrder()

COMPLEXITIES
- Peek: O(1)
- Insert: O(log N)
- Remove root: O(log N)
- Build heap: O(N)

KEY IDEA
A heap is not fully sorted. It only guarantees the ordering
between each parent and its children.
```
