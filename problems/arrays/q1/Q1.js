/**
 * Sorted Squared Array - You are given an array of 
 * Integers in which each subsequent value is not 
 * less than the previous value. Write a function 
 * that takes this array as an input and returns a 
 * new array with the squares of each number sorted 
 * in ascending order.
 */

function sortedSquarredArrayMethod1(array) {
  const NEW_ARRAY = new Array(array.length).fill(0)

  for (let i = 0; i < array.length; i++) {
    NEW_ARRAY[i] = array[i] ** 2
  }

  return bubbleSortAlgorithm(NEW_ARRAY)
}


function sortedSquarredArrayMethod2(array) {
  const NEW_ARRAY = new Array(array.length).fill(0)

  let pointerLeft = 0
  let pointerRight = array.length - 1

  for (let i = 0; i < array.length; i++) {
    const LEFT_SQUARED = Math.pow(array[pointerLeft], 2)
    const RIGHT_SQUARED = Math.pow(array[pointerRight], 2)

    if (LEFT_SQUARED < RIGHT_SQUARED) {
      NEW_ARRAY[i] = LEFT_SQUARED
      pointerLeft++
    } else {
      NEW_ARRAY[i] = RIGHT_SQUARED
      pointerRight--
    }
  }

  return NEW_ARRAY
}

function bubbleSortAlgorithm(array) {
  const SIZE = array.length

  for (let i = 0; i < SIZE - 1; i++) {
    for (let j = 0; j < SIZE - i - 1; j++) {
      if (array[j] > array[j + 1]) {
        const temp = array[j]
        array[j] = array[j + 1]
        array[j + 1] = temp
      }
    }
  }

  return array
}

const SORTED_ARRAY = [5, 4, 3, 2, 1, 0]

console.log(sortedSquarredArrayMethod1(SORTED_ARRAY))
console.log(sortedSquarredArrayMethod2(SORTED_ARRAY))