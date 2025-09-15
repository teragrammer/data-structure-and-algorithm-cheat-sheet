import Foundation

/**
 * Sorted Squared Array - You are given an array of 
 * Integers in which each subsequent value is not 
 * less than the previous value. Write a function 
 * that takes this array as an input and returns a 
 * new array with the squares of each number sorted 
 * in ascending order.
 */

func sortedArrayMethod1(array: [Int]) -> [Int] {
   var newArray = [Int]()

   for num in array {
      newArray.append(Int(pow(Double(num), 2)))
   }

   newArray.sort()
   return newArray
}

func sortedArrayMethod2(array: [Int]) -> [Int] {
   var newArray = [Int]()

   var pointerLeft = 0
   var pointerRight = array.count - 1

   for _ in array {
      let leftSquared = Int(pow(Double(array[pointerLeft]), 2))
      let rightSquared = Int(pow(Double(array[pointerRight]), 2))

      if leftSquared < rightSquared {
         newArray.append(leftSquared)
         pointerLeft += 1
      } else {
         newArray.append(rightSquared)
         if pointerRight >= 0 {
            pointerRight -= 1
         }
      }
   }

   return newArray
}

var array = [5, 4, 3, 2, 1, 0]
print(sortedArrayMethod1(array: array))
print(sortedArrayMethod2(array: array))