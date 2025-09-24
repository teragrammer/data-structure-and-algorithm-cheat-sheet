package main

import (
	"fmt"
	"math"
	"sort"
)

/**
 * Sorted Squared Array - You are given an array of 
 * Integers in which each subsequent value is not 
 * less than the previous value. Write a function 
 * that takes this array as an input and returns a 
 * new array with the squares of each number sorted 
 * in ascending order.
 */

func sortedSquarredArrayMethod1(arr []int) []int {
	var newArray []int

	for i := 0; i < len(arr); i++ {
		newArray = append(newArray, int(math.Pow(float64(arr[i]), 2)))
	}

	sort.Ints(newArray[:])

	return newArray
}

func sortedSquarredArrayMethod2(arr []int) []int {
	var newArray []int

	var leftPointer = 0
	var rightPointer = len(arr) - 1

	for i := 0; i < len(arr); i++ {
		var leftSquared = int(math.Pow(float64(arr[leftPointer]), 2))
		var rightSquared = int(math.Pow(float64(arr[rightPointer]), 2))

		if leftSquared < rightSquared {
			newArray = append(newArray, leftSquared)
			leftPointer++
		} else {
			newArray = append(newArray, rightSquared)
			rightPointer--
		}
	}

	return newArray
}

func main() {
	var array = []int{5, 4, 3, 2, 1, 0}

	var newArrayMethod1 = sortedSquarredArrayMethod1(array)
	fmt.Println(newArrayMethod1)

	var newArrayMethod2 = sortedSquarredArrayMethod2(array)
	fmt.Println(newArrayMethod2)
}