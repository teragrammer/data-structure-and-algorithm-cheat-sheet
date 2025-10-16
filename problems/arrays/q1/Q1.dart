import 'dart:math';

// Sorted Squared Array - You are given an array of 
// Integers in which each subsequent value is not 
// less than the previous value. Write a function 
// that takes this array as an input and returns a 
// new array with the squares of each number sorted 
// in ascending order.

List<int> sortedSquaredMethod1(List<int> array) {
    List<int> newArray = List.filled(array.length, 0);

    for (int i = 0; i < array.length; i++) {
        int base = array[i];
        newArray[i] = (pow(base, 2)).toInt();
    }

    return bubbleSortAlgorithm(newArray);
}

List<int> sortedSquaredMethod2(List<int> array) {
    List<int> newArray = List.filled(array.length, 0);

    int leftPointer = 0;
    int rightPointer = array.length - 1;

    for (int i = 0; i < array.length; i++) {
        int leftSquared = (pow(array[leftPointer], 2)).toInt();
        int rightSquared = (pow(array[rightPointer], 2)).toInt();

        if (leftSquared < rightSquared) {
            newArray[i] = leftSquared;
            leftPointer++;
        } else {
            newArray[i] = rightSquared;
            rightPointer--;
        }
    }

    return newArray;
}

List<int> bubbleSortAlgorithm(List<int> array) {
    int size = array.length;

    for (int i = 0; i < size - 1; i++) {
        for (int j = 0; j < size - i - 1; j++) {
            if (array[j] > array[j + 1]) {
                int temp = array[j];
                array[j] = array[j + 1];
                array[j + 1] = temp;
            }
        }
    }

    return array;
}

void main() {
    List<int> array = [5, 4, 3, 2, 1, 0];

    print(sortedSquaredMethod1(array));
    print(sortedSquaredMethod2(array));
}