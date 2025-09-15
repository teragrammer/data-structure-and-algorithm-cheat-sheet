#include <iostream>
#include <cmath>
#include <algorithm>
using namespace std;

/**
 * Sorted Squared Array - You are given an array of 
 * Integers in which each subsequent value is not 
 * less than the previous value. Write a function 
 * that takes this array as an input and returns a 
 * new array with the squares of each number sorted 
 * in ascending order.
 */

int* sortedSquarredArrayMethod1(int array[], int length) {
    int* newArray = new int[length];

    for (int i = 0; i < length; i++) {
        newArray[i] = pow(array[i], 2);
    }

    sort(newArray, newArray + length);
    
    return newArray;
}

int* sortedSquarredArrayMethod2(int array[], int length) {
    int* newArray = new int[length];

    int pointerLeft = 0;
    int pointerRight = length - 1;

    for (int i = 0; i < length; i++) {
        int leftSquared = pow(array[pointerLeft], 2);
        int rightSquared = pow(array[pointerRight], 2);

        if (leftSquared < rightSquared) {
            newArray[i] = leftSquared;
            pointerLeft++;
        } else {
            newArray[i] = rightSquared;
            pointerRight--;
        }
    }

    return newArray;
}

int main() {
    int array[] = {5, 4, 3, 2, 1, 0};
    int lengthArr = sizeof(array) / sizeof(array[0]);

    // Print Method 1
    int* arrayMethod1 = sortedSquarredArrayMethod1(array, lengthArr);
    for (int i = 0; i < lengthArr; i++) {
        std::cout << arrayMethod1[i] << " ";
    }
    std::cout << std::endl;

    // Print Method 2
    int* arrayMethod2 = sortedSquarredArrayMethod2(array, lengthArr);
    for (int i = 0; i < lengthArr; i++) {
        std::cout << arrayMethod2[i] << " ";
    }
    std::cout << std::endl;

    return 0;
}
