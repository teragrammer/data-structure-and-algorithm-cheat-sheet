#include <iostream>
#include <cmath>
#include <algorithm>
using namespace std;

// Given an array, 
// rotate the array to the right by k steps, 
// where k is non-negative.

void rotateArrayMethod1(int array[], int size, int k) {
    k = k % size;
    int temp[k];

    // store last k elements in temp
    for (int i = 0; i < k; i++) {
        temp[i] = array[size - k + i];
    }

    // shift rest of array right by k
    for (int i = size - k - 1; i >= 0; i--) {
        array[i + k] = array[i];
    }

    // copy temp elements to front
    for (int i = 0; i < k; i++) {
        array[i] = temp[i];
    }
}

int main() {
    int arrayMethod1[] = {1, 2, 3, 4, 5};
    int lengthArr = sizeof(arrayMethod1) / sizeof(arrayMethod1[0]);
    int k = 3;

    rotateArrayMethod1(arrayMethod1, lengthArr, k);
    for (int i = 0; i < lengthArr; i++) {
        std::cout << arrayMethod1[i] << " ";
    }
    std::cout << std::endl;
}