// Given an array, 
// rotate the array to the right by k steps, 
// where k is non-negative.

function rotateArrayMethod1(array = [], k) {
    if (array.length == k || array.length == 0) return array

    let counter = 1
    for (let i = 0; i < array.length; i++) {
        if (counter <= k) {
            const lastItem = array[array.length - 1]
            array.pop()
            array.unshift(lastItem)
            counter++
        }
    }

    return array
}

const array = [1, 2, 3, 4, 5]
const k = 3

console.log(rotateArrayMethod1(array, k))