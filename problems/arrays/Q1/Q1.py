"""
Sorted Squared Array - You are given an array of 
Integers in which each subsequent value is not 
less than the previous value. Write a function 
that takes this array as an input and returns a 
new array with the squares of each number sorted 
in ascending order.
"""

def sorted_squared_method_1(array):
    new_array = [0] * len(array)

    for i in range(len(array)):
        new_array[i] = array[i] ** 2

    new_array.sort()
    return new_array

def sorted_squared_method_2(array):
    new_array = [0] * len(array)

    pointer_left = 0
    pointer_right = len(array) - 1

    for i in range(len(array)):
        squared_left = array[pointer_left] ** 2
        squared_right = array[pointer_right] ** 2

        if squared_left < squared_right:
            new_array[i] = squared_left
            pointer_left = pointer_left + 1
        else:
            new_array[i] = squared_right
            pointer_right = pointer_right - 1

    return new_array

print(sorted_squared_method_1([5, 4, 3, 2, 1, 0]))
print(sorted_squared_method_2([5, 4, 3, 2, 1, 0]))