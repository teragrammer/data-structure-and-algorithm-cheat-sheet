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
}

fun sortedSquaredMethod1(array: Array<Int>): Array<Int> {
    var newArray = arrayOf<Int>();

    for ((i, _) in array.withIndex()) {
        val base = array[i];
        newArray += (base.toDouble().pow(2)).toInt();
    }

    return bubbleSortAlgorithm(newArray);
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