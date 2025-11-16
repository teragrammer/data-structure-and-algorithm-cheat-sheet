#include <iostream>
#include <vector>
using namespace std;

/*
* Given an array of integers nums and an integer target, 
* return indices of the two numbers such that 
* they add up to target.
*/

// Brute Force Solution
int* twoSumMethod1(int nums[], int target, int size) {
    int* indices = new int[2];
    indices[0] = -1;
    indices[1] = -1;

    for (int i = 0; i < size; i++) {
        for (int j = 0; j < size - 1; j++) {
            int sum = nums[i] + nums[j];
            if (sum == target) {
                indices[0] = i;
                indices[1] = j;
                return indices;
            }
        }
    }

    return indices;
}

// Optimal Solution
int* twoSumMethod2(int nums[], int target, int size) {
    int* indices = new int[2];
    indices[0] = -1;
    indices[1] = -1;

    // TODO

    return indices;
}

int main() {
    int nums[] = {6, 3, 1, 5, 2};
    int target = 3;
    int size = sizeof(nums) / sizeof(nums[0]);

    int* indices1 = twoSumMethod1(nums, target, size);
    if (indices1[0] > 0 && indices1[1] > 0) {
        cout << "Sum: " << nums[indices1[0]] + nums[indices1[1]] << 
        " Indices: " << indices1[0] << ", " << indices1[1] << endl;
    }

    return 0;
}