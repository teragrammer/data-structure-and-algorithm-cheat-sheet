# Sorted Squared Array - You are given an array of 
# Integers in which each subsequent value is not 
# less than the previous value. Write a function 
# that takes this array as an input and returns a 
# new array with the squares of each number sorted 
# in ascending order.

sorted_squared_method_1 <- function(array) {
    new_array <- c(1:length(array))

    for (i in seq_along(array)) {
        new_array[i] = array[i] ** 2
    }

    return(sort(new_array))
}

sorted_squared_method_2 <- function(array) {
    new_array = c(1:length(array))

    pointer_left = 1
    pointer_right = length(array)

    for (i in seq_along(array)) {
        squared_left = array[pointer_left] ** 2
        squared_right = array[pointer_right] ** 2

        if (squared_left < squared_right) {
            new_array[i] = squared_left
            pointer_left = pointer_left + 1
        } else {
            new_array[i] = squared_right
            pointer_right = pointer_right - 1
        }
    }

    return(new_array)
}

array = c(5, 4, 3, 2, 1, 0)

print(sorted_squared_method_1(array))
print(sorted_squared_method_2(array))