// Given an array, 
// rotate the array to the right by k steps, 
// where k is non-negative.

fun main() {
    val array = arrayOf<Int>(1, 2, 3, 4, 5);
    val k = 3;

    println(rotateArrayMethod1(array, k).joinToString());
}

fun rotateArrayMethod1(array: Array<Int>, k: Int): Array<Int> {
    if (array.size == k || array.size == 0) {
        return array;
    }

    val list = array.toMutableList();

    var counter = 1;
    for (i in 0 until list.size) {
        if (counter <= k) {
            val lastItem = list[list.size - 1];
            list.removeAt(list.size - 1);
            list.add(0, lastItem);
            
            counter += 1;
        }
    }

    return list.toTypedArray();
}