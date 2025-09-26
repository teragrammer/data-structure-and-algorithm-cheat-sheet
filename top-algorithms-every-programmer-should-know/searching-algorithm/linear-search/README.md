### Linear Search Algorithm

method for finding a specific element in a list or array. It works by sequentially checking each element in the list from the beginning to the end until the target element is found or the list is fully traversed. It’s straightforward but can be slow for large datasets since it examines each element one by one.

### Key Characteristics

- **Time Complexity:** O(n), where n is the number of elements in the list (linear time).
- **Space Complexity:** O(1), as it uses a constant amount of extra space.
- **Use Case:** Best for small or unsorted lists where other algorithms (like binary search) aren’t applicable.

### How It Works:

1. Start at the first element of the list.
2. Compare the current element with the target value.
3. If they match, return the index (or a confirmation of the element’s presence).
4. If not, move to the next element.
5. Repeat until the target is found or the end of the list is reached.
6. If the end is reached without finding the target, indicate that the element is not in the list.