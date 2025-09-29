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

array = c(5, 4, 3, 2, 1, 0)

print(sorted_squared_method_1(array))