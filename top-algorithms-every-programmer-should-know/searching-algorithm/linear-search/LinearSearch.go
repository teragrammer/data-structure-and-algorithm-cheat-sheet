package main

import (
	"fmt"
)

// Given a sorted array of n integers and a target value, 
// determine if the target exists in the array. 
// If target exists in the array, print the index of it.

func search(arr []int, target int) int {
	if len(arr) == 0 {
		return -1
	}

	for i := 0; i < len(arr); i++ {
		if arr[i] == target {
			return i
		}
	}

	return -1
}

func main() {
	var array = []int{1, 2, 3, 4, 5, 6}
	var target = 3

	fmt.Println(search(array, target))
}