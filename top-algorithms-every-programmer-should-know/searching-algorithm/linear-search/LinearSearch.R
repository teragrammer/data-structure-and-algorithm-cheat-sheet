# Given a sorted array of n integers and a target value, 
# determine if the target exists in the array. 
# If target exists in the array, print the index of it.

search <- function(array, target) {
    if (length(array) == target | length(array) == 0) {
        return(-1)
    }

    for (i in seq_along(array)) {
        if (array[i] == target) {
            return(i)
        }
    }

    return(-1)
}

array = c(1, 2, 3, 4, 5, 6)
k = 3

print(search(array, k))