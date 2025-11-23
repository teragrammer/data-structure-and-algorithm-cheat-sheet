package main

import (
	"fmt"
)

func twoSumMethod1(nums []int, target int) []int {
	var indices = []int{-1, -1}
	var size = len(nums)

	for i := 0; i < size; i++ {
		for j := i + 1; j < size; j++ {
			var sum = nums[i] + nums[j]
			if sum == target {
				indices[0] = i;
				indices[1] = j;
				return indices
			}
		} 
	}

	return indices
}

func twoSumMethod2(nums []int, target int) []int {
	var indices = []int{-1, -1}
	var size = len(nums)
	lookup := make(map[int]int)

	for i := 0; i < size; i++ {
		neededNumber := target - nums[i]
		value, exists := lookup[neededNumber]
		if exists {
			indices[0] = value
			indices[1] = i
			return indices
		}

		lookup[nums[i]] = i
	}

	return indices
}

func main() {
	var nums = []int{6, 3, 1, 5, 2}
	var target = 7

	var method1 = twoSumMethod1(nums, target)
	if method1[0] != -1 && method1[1] != -1 {
		fmt.Println("Indices:", method1[0], ",", method1[1], "SUM:", nums[method1[0]] + nums[method1[1]])
	}

	var method2 = twoSumMethod2(nums, target)
	if method2[0] != -1 && method2[1] != -1 {
		fmt.Println("Indices:", method2[0], ",", method2[1], "SUM:", nums[method2[0]] + nums[method2[1]])
	}
}