package main

import (
	"fmt"
)

// Given an array, 
// rotate the array to the right by k steps, 
// where k is non-negative.

func rotateArrayMethod1(arr []int, k int) []int {
	if len(arr) == k || len(arr) == 0 {
		return arr
	}

	counter := 1
	for i := 0; i < len(arr); i++ {
		if counter <= k {
			lastItem := arr[len(arr) - 1]
			arr = arr[:len(arr) - 1]
			arr = append([]int{lastItem}, arr...)
			counter++
		}
	}

	return arr
}

func main() {
	var array = []int{1, 2, 3, 4, 5}
	var k = 3

	var newArrayMethod1 = rotateArrayMethod1(array, k)
	fmt.Println(newArrayMethod1)
}