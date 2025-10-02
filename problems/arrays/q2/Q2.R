# Given an array, 
# rotate the array to the right by k steps, 
# where k is non-negative.

rotate_array_method_1 <- function(array, k) {
    if (length(array) == k || length(array) == 0) {
        return(array)
    }

    counter = 1
    for (i in seq_along(array)) {
        if (counter <= k) {
            last_item = array[length(array)] # get the last item
            array = array[-length(array)] # delete the last item
            array = c(last_item, array) # add the last item
            counter = counter + 1
        }
    }

    return(array)
}

array = c(1,2,3,4,5)
k = 3

rotate_array_method_1(array, k)