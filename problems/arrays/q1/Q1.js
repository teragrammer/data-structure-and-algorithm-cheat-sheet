/**
 * Sorted Squared Array - You are given an array of 
 * Integers in which each subsequent value is not 
 * less than the previous value. Write a function 
 * that takes this array as an input and returns a 
 * new array with the squares of each number sorted 
 * in ascending order.
 */

function sortedSquarredArrayMethod1(array) {
  const newArray = new Array(array.length).fill(0)

  for (let i = 0; i < array.length; i++) {
    newArray[i] = array[i] ** 2
  }

  return bubbleSortAlgorithm(newArray)
}


function sortedSquarredArrayMethod2(array) {
  const newArray = new Array(array.length).fill(0)

  let pointerLeft = 0
  let pointerRight = array.length - 1

  for (let i = 0; i < array.length; i++) {
    const leftSquared = Math.pow(array[pointerLeft], 2)
    const rightSquared = Math.pow(array[pointerRight], 2)

    if (leftSquared < rightSquared) {
      newArray[i] = leftSquared
      pointerLeft++
    } else {
      newArray[i] = rightSquared
      pointerRight--
    }
  }

  return newArray
}

function bubbleSortAlgorithm(array) {
  const size = array.length

  for (let i = 0; i < size - 1; i++) {
    for (let j = 0; j < size - i - 1; j++) {
      if (array[j] > array[j + 1]) {
        const temp = array[j]
        array[j] = array[j + 1]
        array[j + 1] = temp
      }
    }
  }

  return array
}

const array = [5, 4, 3, 2, 1, 0]

console.log(sortedSquarredArrayMethod1(array))
console.log(sortedSquarredArrayMethod2(array))