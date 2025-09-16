// Given an array, 
// rotate the array to the right by k steps, 
// where k is non-negative.

func rotateArrayMethod1(array: [Int], k: Int) -> [Int] {
    var newArray: [Int] = array
    if newArray.count == k || newArray.count == 0 {
        return newArray
    }

    var counter = 1
    for _ in newArray {
        if counter <= k {
            let lastItem = newArray[newArray.count - 1]
            newArray.removeLast()
            newArray.insert(lastItem, at: 0)
            counter += 1
        }
    }

    return newArray
}

var array = [1, 2, 3, 4, 5]
var k = 3
print(rotateArrayMethod1(array: array, k: k))