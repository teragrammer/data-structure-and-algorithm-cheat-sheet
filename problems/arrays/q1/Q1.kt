import kotlin.math.pow

// Sorted Squared Array - You are given an array of 
// Integers in which each subsequent value is not 
// less than the previous value. Write a function 
// that takes this array as an input and returns a 
// new array with the squares of each number sorted 
// in ascending order.

fun main() {
    val array = arrayOf<Int>(5, 4, 3, 2, 1, 0);

    println(sortedSquaredMethod1(array).joinToString());
    println(sortedSquaredMethod2(array).joinToString());
}

fun sortedSquaredMethod1(array: Array<Int>): Array<Int> {
    var newArray = arrayOf<Int>();

    for ((i, _) in array.withIndex()) {
        val base = array[i];
        newArray += (base.toDouble().pow(2)).toInt();
    }

    return bubbleSortAlgorithm(newArray);
}

fun sortedSquaredMethod2(array: Array<Int>): Array<Int> {
    var newArray = arrayOf<Int>();

    var leftPointer = 0;
    var rightPointer = array.size - 1;

    for (i in 0 until array.size) {
        val squaredLeft = (array[leftPointer].toDouble().pow(2)).toInt();
        val squaredRight = (array[rightPointer].toDouble().pow(2)).toInt();

        if (squaredLeft < squaredRight) {
            newArray += squaredLeft;
            leftPointer += 1;
        } else {
            newArray += squaredRight;
            rightPointer -= 1;
        }
    }

    return newArray;
}

fun bubbleSortAlgorithm(array: Array<Int>): Array<Int> {
    val n = array.size

    for (i in 0 until n - 1) {
        for (j in 0 until n - i - 1) {
            if (array[j] > array[j + 1]) {
                // swap element
                val temp = array[j];
                array[j] = array[j + 1];
                array[j + 1] = temp;
            }
        }
    }

    return array;
}