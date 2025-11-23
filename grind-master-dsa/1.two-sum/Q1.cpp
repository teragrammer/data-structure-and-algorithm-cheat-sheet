#include <iostream>
#include <vector>
#include <unordered_map>
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
        for (int j = i + 1; j < size; j++) {
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
    
    unordered_map<int, int> lookup;

    for (int i = 0; i < size; i++) {
        int neededNumber = target - nums[i];

        if (lookup.find(neededNumber) != lookup.end()) {
            indices[0] = lookup[neededNumber];
            indices[1] = i;
            return indices;
        }

        lookup[nums[i]] = i;
    }

    return indices;
}

int main() {
    int nums[] = {6, 3, 1, 5, 2};
    int target = 7;
    int size = sizeof(nums) / sizeof(nums[0]);

    int* indices1 = twoSumMethod1(nums, target, size);
    if (indices1[0] != -1 && indices1[1] != -1) {
        cout << "Method 1.) Sum: " << nums[indices1[0]] + nums[indices1[1]] << 
        " Indices: " << indices1[0] << ", " << indices1[1] << endl;
    }

    int* indices2 = twoSumMethod2(nums, target, size);
    if (indices2[0] != -1 && indices2[1] != -1) {
        cout << "Method 2.) Sum: " << nums[indices2[0]] + nums[indices2[1]] << 
        " Indices: " << indices2[0] << ", " << indices2[1] << endl;
    }

    return 0;
}