# Greedy Method in DSA

## 1. What is the Greedy Method?

The **Greedy Method** is an algorithmic approach in which we make the best possible choice at the current moment (locally optimal choice), hoping that these choices will lead to the best overall solution (globally optimal solution).

In simple words:

> Make the best decision at the current step without worrying about changing previous decisions.

Once a choice is made, we generally do not reconsider it.

### Real-life Example

Imagine you have ₹100 and want to purchase as many items as possible.

| Item | Price |
|---|---:|
| A | ₹10 |
| B | ₹20 |
| C | ₹30 |
| D | ₹50 |

A greedy approach would select the cheapest items first.

- Select A → ₹10
- Select B → ₹20
- Select C → ₹30
- Select D → ₹50

Total = ₹110, which exceeds the budget.

Therefore, we select A, B and C, spending ₹60.

The idea is to make the best immediate choice at every step.

---

## 2. How Does the Greedy Approach Work?

Generally, a greedy algorithm follows these steps:

1. **Understand the problem:** Identify what needs to be maximized or minimized.
2. **Define a greedy choice:** Decide what the best immediate decision should be.
3. **Make the choice:** Select the locally optimal option.
4. **Update the problem:** Update the remaining elements or available resources.
5. **Repeat:** Continue until the problem is solved or no more valid choices exist.

### General Flow

```text
Start
  |
  v
Understand the problem
  |
  v
Identify the best immediate choice
  |
  v
Is the choice valid?
  |
  +---- No ----> Skip / Stop
  |
  Yes
  |
  v
Make the choice
  |
  v
Update the problem
  |
  v
Repeat until completion
  |
  v
Return the result
```

---

## 3. Example: Assign Cookies (LeetCode 455)

**Problem:**

There are `n` children, each having a greed factor, and `m` cookies, each having a size.

- Each child needs a cookie whose size is greater than or equal to their greed factor.
- Each cookie can be assigned to only one child.
- Our goal is to maximize the number of satisfied children.

### Input

```java
int[] g = {1, 2, 3}; // Greed factors
int[] s = {1, 1};    // Cookie sizes
```

### Greedy Strategy

Always try to satisfy the least greedy child with the smallest available cookie that is sufficient.

First, sort both arrays:

```text
Children: [1, 2, 3]
Cookies:  [1, 1]
```

### Dry Run

| Child greed | Cookie size | Decision |
|---:|---:|---|
| 1 | 1 | Assign cookie |
| 2 | 1 | Cookie too small |
| 2 | No cookies left | Stop |

**Result: 1 satisfied child.**

### Why Does This Work?

- Sorting helps us process the least greedy child first.
- We avoid wasting larger cookies on children who can be satisfied with smaller ones.
- Every cookie is assigned at most once.

---

## 4. Java Implementation

```java
import java.util.Arrays;

class Solution {
    public int findContentChildren(int[] g, int[] s) {

        // Sort children and cookies
        Arrays.sort(g);
        Arrays.sort(s);

        int i = 0; // Pointer for children
        int j = 0; // Pointer for cookies

        while (i < g.length && j < s.length) {

            // Check whether the cookie can satisfy the child
            if (s[j] >= g[i]) {
                i++; // Child is satisfied
            }

            j++; // Move to the next cookie
        }

        return i;
    }
}
```

### Understanding the Two Pointers

- `i` tracks the current child.
- `j` tracks the current cookie.
- If the cookie is sufficiently large, satisfy the child and move to the next child.
- Otherwise, skip the cookie and try the next one.

**Important:** The cookie pointer always moves forward, so a cookie cannot be reused.

---

## 5. Important Properties of Greedy Algorithms

### A. Greedy Choice Property

A globally optimal solution can be obtained by making a locally optimal choice at each step.

In other words, the best immediate decision should be safe to make.

### B. Optimal Substructure

An optimal solution to a problem can be constructed using optimal solutions to its smaller subproblems.

These properties help establish when a greedy strategy is valid.

---

## 6. Greedy vs Dynamic Programming

| Greedy | Dynamic Programming |
|---|---|
| Makes the best immediate choice | Solves and combines smaller subproblems |
| Usually does not reconsider choices | Stores previous results |
| Often simpler and faster | May require more time and space |
| Does not work for every optimization problem | Can solve many problems where greedy fails |

### Example: Coin Change

Available coins:

```text
Coins = [1, 3, 4]
Amount = 6
```

**Greedy approach:**

- Choose 4
- Choose 1
- Choose 1

Result = 3 coins.

**Optimal approach:**

- Choose 3
- Choose 3

Result = 2 coins.

This demonstrates that greedy does not always produce the optimal answer.

---

## 7. Time and Space Complexity

For the Assign Cookies problem:

| Operation | Time Complexity |
|---|---|
| Sort children | O(n log n) |
| Sort cookies | O(m log m) |
| Two-pointer traversal | O(n + m) |

**Overall Time Complexity:**

`O(n log n + m log m)`

Auxiliary space depends on the sorting implementation.

---

## 8. Common Greedy Problems to Practice

| Problem | Difficulty |
|---|---|
| [Assign Cookies](https://leetcode.com/problems/assign-cookies/) | Easy |
| [Lemonade Change](https://leetcode.com/problems/lemonade-change/) | Easy |
| [Best Time to Buy and Sell Stock II](https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/) | Medium |
| [Jump Game](https://leetcode.com/problems/jump-game/) | Medium |
| [Gas Station](https://leetcode.com/problems/gas-station/) | Medium |
| [Non-overlapping Intervals](https://leetcode.com/problems/non-overlapping-intervals/) | Medium |
| [Partition Labels](https://leetcode.com/problems/partition-labels/) | Medium |

---

## 9. Important Interview Takeaways

1. Greedy means choosing the locally optimal option at every step.
2. Sorting is commonly used to make greedy decisions easier.
3. Greedy algorithms often use two pointers, sorting, heaps or intervals.
4. Greedy choices are generally irreversible.
5. Greedy does not guarantee an optimal answer for every problem.
6. Always understand and justify why the greedy choice works before implementing it.

### Key Takeaway

**Greedy = Make the best possible choice now, update the problem, and repeat.**

The most important part of solving greedy problems is not writing the code. It is identifying the correct greedy strategy and proving why it leads to an optimal solution.