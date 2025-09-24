"""
Given an array, 
rotate the array to the right by k steps, 
where k is non-negative.
"""

def rotate_array_method_1(array, k):
    if len(array) == k or len(array) == 0:
        return array
    
    counter = 1
    for i in range(k):
        if counter <= k:
            moveItem = array[len(array) - 1]
            del array[-1]
            array.insert(0, moveItem)
            counter += 1
    
    return array

print(rotate_array_method_1([1, 2, 3, 4, 5], 3))
