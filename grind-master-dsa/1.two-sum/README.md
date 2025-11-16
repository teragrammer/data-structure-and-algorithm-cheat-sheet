# Two Sum

Given an array of integers **nums** and an integer **target**, return indices of the two numbers such that they add up to **target**.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

- Example 1:

    ```Text
    Input: nums = [2,7,11,15], target = 9
    Output: [0,1]
    Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
    ```

- Example 2:

    ```Text
    Input: nums = [3,2,4], target = 6
    Output: [1,2]
    ```

- Example 3:

    ```Text
    Input: nums = [3,3], target = 6
    Output: [0,1]
    ```

### Clarifying Questions

This question is often ambiguous in real interviews, especially at FAANG companies. When faced with it, be sure to clarify:

These clarifications help avoid misunderstandings and guide your solution approach.

1. What is the range of integer values in the nums array?

2. Can nums include duplicates, and do duplicates affect which indices to return?

3. Will nums always have at least two elements?

4. If multiple pairs sum to the target, which pair should be returned (e.g., the one with the smallest indices)?

5. Could the target be outside any possible sum from nums?

### Brute Force Solution

The brute force approach involves checking every possible pair in the array to see if their sum matches the target. You compare each number with every other number until you find the correct pair.

**The algorithm works like this:**

1. Start with the first number.

2. Add it to each subsequent number one by one, checking if the sum equals the target.

3. If no pair is found, move to the second number.

4. Add the second number to every number that comes after it, checking each sum.

5. Repeat this process for each number, always pairing it only with numbers that follow it.

6. Stop when you find a pair whose sum matches the target.

### Big(O) Analysis

**Time Complexity**

**O(n²)** The brute force algorithm scans the array of size *n* by comparing each element with every following element to find a pair summing to the target.

- The first element makes *n − 1* comparisons.

- The second element makes *n − 2* comparisons.

- This continues until the second-to-last element.

The total comparisons sum to approximately *n * (n-1) / 2*, which simplifies to a time complexity of O(n²).

**Space Complexity**

**O(1)** The brute force approach iterates through the input array without using any additional data structures like lists or hash maps. It only uses a fixed number of variables for indexing the pairs being checked. 

Because these variables require constant space regardless of the input size \(N\), the auxiliary space complexity is \(O(1)\), meaning constant space.

### Optimal Solution

The efficient solution uses a data structure (like a hash map) to store numbers we've seen so far. As we iterate through the array, for each number, we check if its complement (the value needed to reach the target) is already stored. This lets us find a matching pair in a single pass without checking every combination.

The algorithm works as follows:

1. Create a fast lookup tool (like a hash map) to quickly check if a number exists and where.

2. Start with the first number in the list.

3. Calculate the number needed to reach the target sum.

4. Check the lookup tool to see if this needed number has been seen before.

5. If found, return the pair - problem solved.

6. If not found, add the current number to the lookup tool for future checks.

7. Move to the next number and repeat steps 3 - 6.

8. Continue until a matching pair is found or all numbers are processed.

### Big(O) Analysis

**Time Complexity**

**O(n)** The algorithm makes a single pass through the input array of size (n). For each element, it performs a constant-time lookup in a hash table to check if the complement exists. Inserting elements into the hash table also takes constant time on average.

Because these operations happen once per element, the overall time complexity is (O(n)).

**Space Complexity**

**O(N)** The algorithm uses a lookup tool, typically a hash map or dictionary, to store each number along with its index as it processes the input list.

In the worst case - when no two numbers sum to the target - the hash map stores all (N) numbers.

Thus, the auxiliary space complexity is (O(N)), growing linearly with the input size.