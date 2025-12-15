# LRU Cache

Design a data structure that implements the behavior of a **Least Recently Used (LRU) cache** under strict performance constraints.

### Class Specification: `LRUCache`

#### **Constructor**

- **`LRUCache(int capacity)`**  

  Initializes the cache with a given positive **capacity**, representing the maximum number of key–value pairs it can store.

#### **Operations**

- **`int get(int key)`**  

  - Returns the value associated with `key` if it exists in the cache.  

  - If the key is not present, returns **`-1`**.  

  - Accessing a key marks it as **recently used**.

- **`void put(int key, int value)`**  

  - Inserts a new `key–value` pair or updates an existing key's value.  

  - Marks the key as **recently used**.  

  - If insertion causes the number of entries to exceed the cache's capacity, the **least recently used** key must be evicted.

### Performance Requirement

Both **`get`** and **`put`** must operate in **O(1)** average time.  
This typically requires combining:
- A **hash map** for constant-time lookup, and  

- A **doubly linked list** to maintain recency ordering with constant-time updates and removals.

Example 1:

```TEXT
Input
["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
[[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]

Output
[null, null, null, 1, null, -1, null, -1, 3, 4]

Explanation
LRUCache lRUCache = new LRUCache(2);
lRUCache.put(1, 1); // cache is {1=1}
lRUCache.put(2, 2); // cache is {1=1, 2=2}
lRUCache.get(1);    // return 1
lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
lRUCache.get(2);    // returns -1 (not found)
lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
lRUCache.get(1);    // return -1 (not found)
lRUCache.get(3);    // return 3
lRUCache.get(4);    // return 4
```

### Clarifying Questions

In real-world interviews (especially at FAANG), the LRU Cache prompt is often intentionally ambiguous.  
You should ask clarifying questions to avoid incorrect assumptions:

1. **What data types are used for keys and values?**  

   - Are they guaranteed to be integers, or can they be arbitrary objects/types?

2. **What should `get(key)` return when the key is not found?**  

   - Should it return `-1`, `null`, throw an exception, or something else?

3. **Are there constraints on the cache capacity?**  

   - Can `capacity` be zero?  

   - What is the expected behavior when the cache has zero capacity?  

   - Are negative capacities possible and how should they be handled?

4. **How should `put(key, value)` behave when the key already exists?** 

   - Should this be treated as an update?  

   - Does updating or reinserting the key count as marking it “most recently used”?

5. **Are there constraints on the valid ranges for keys, values, or capacity?**  

   - Could extremely large ranges influence memory usage or data structure choice?  

   - Are there any performance or memory limits we should be aware of?

Asking these questions demonstrates attention to detail, prevents misinterpretation, and aligns your solution with real-world expectations.

### Brute Force Solution

A naive way to implement an LRU cache is to store all items in a simple ordered list.  
Every `get` or `put` operation requires scanning the entire list to find items and determine which one is the least recently used.

### Step-by-Step Algorithm

1. **Represent the cache as an ordered list.**  

   - The front of the list holds the most recently used item. 

   - The back holds the least recently used item.

2. **Retrieving an item (`get`)**  

   - Scan the list from the front to the back until the key is found. 

   - If the key is found, remove it from its current position and move it to the **front** to mark it as recently used.

3. **Adding or updating an item (`put`)**  

   - First, scan the entire list to check whether the key already exists. 

   - **If the key exists**: update its value (if needed) and move it to the **front**.  

   - **If the key does not exist**:

     - If the cache is **not full**, simply insert the item at the front.  

     - If the cache **is full**:

       1. Identify and remove the item at the **end** of the list (the least recently used).  

       2. Insert the new item at the **front**.

**Summary**

This brute-force method works conceptually but is inefficient because both `get` and `put` operations require scanning the entire list, resulting in **O(n)** time per operation.

### Big(O) Analysis

**Time Complexity**

**O(n)** The brute-force LRU approach requires scanning the entire list for every `get` and `put` operation.

- For a **get** operation, we may need to search through all `n` items to find the key.

- For a **put** operation:

  - If the key already exists, we must scan the full list to locate it (**O(n)**), then remove and reinsert it at the front (each removal/insert is also **O(n)** in a list).

  - If the key does not exist and the cache is full, we scan to ensure the key isn’t present (**O(n)**) and then remove the least recently used item at the end (which also costs **O(n)** in a simple list).

Because each of these operations depends linearly on the number of items in the cache, the overall time complexity for both `get` and `put` is **O(n)**.

**Space Complexity**

**O(capacity)** The brute-force implementation stores all cache entries in a single ordered list.  
Because the cache can hold at most `capacity` items, the amount of memory required grows linearly with this limit.  

No additional auxiliary data structures beyond this list are used, so the total space consumption is directly proportional to the cache's maximum capacity.

### Optimal Solution

To achieve an efficient LRU Cache with **O(1)** time for both `get` and `put`, we combine two key data structures:

- **A hash map** for constant-time lookup of items.

- **A doubly linked list** to maintain the usage order, allowing constant-time removal and insertion of nodes.

Together, these structures let us instantly find any item and also update its position in the usage order without scanning the entire cache.

### Step-by-Step Algorithm

1. **Fast Lookup Structure**  

   Maintain a hash map (dictionary) that maps each key to:

   - Its value 

   - A pointer to the node representing that item in the doubly linked list

2. **Usage Order Structure**  

   Keep all items in a doubly linked list arranged from:
   - **Front:** Most recently used  

   - **Back:** Least recently used  

3. **Marking an Item as Recently Used**  

   Whenever we access or insert an item, move its node to the **front** of the list to mark it as the most recently used.

4. **Accessing an Existing Item (`get`)**  

   - Look up the key in the hash map in **O(1)** time.  

   - If it exists, move its associated node to the **front** of the list.  

   - Return its value.

5. **Inserting or Updating an Item (`put`)**  

   - If the key already exists: update its value and move its node to the front.  

   - If the key does *not* exist:

     - If the cache has space, proceed to insert.  

     - If the cache is full, remove the node at the **back** of the list (the least recently used item).

6. **Evicting the Least Recently Used Item**  

   - Remove the node at the back of the doubly linked list.  

   - Delete its key from the hash map to keep the structures consistent.

7. **Adding the New Item**  

   - Insert a new node at the **front** of the list.  

   - Add the key–node mapping to the hash map for fast future lookup.

This combined design guarantees **O(1)** operations by avoiding list scans and enabling constant-time insertions, deletions, and lookups.

### Big(O) Analysis

**Time Complexity**

**O(1)** Both `get` and `put` operate in constant time due to the combination of a hash map and a doubly linked list.

- **Hash map lookups** (for checking existence or retrieving a node) take constant time.
- **Moving a node to the front** of the doubly linked list is an O(1) operation because each node has direct references to its neighbors.
- **Evicting the least recently used item** (removing the tail node) is also O(1) since the tail pointer gives direct access.
- **Inserting a new node at the head** is O(1).

Because all operations required for both `get` and `put` are performed in a fixed number of constant-time steps—independent of the cache’s capacity—the overall time complexity is **O(1)**.

**Space Complexity**

**O(C)** The space usage is driven by the two core data structures:  

- A **hash map** that provides constant-time lookup  

- A **doubly linked list** that maintains usage order  

Both structures store at most **C** entries, where **C** is the cache’s capacity.  
Each cached item appears once in the hash map and once as a node in the linked list.

Because the amount of memory required grows linearly with the number of items the cache can hold, the overall space complexity is **O(C)**.
