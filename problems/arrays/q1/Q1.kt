import kotlin.math.pow

fun main() {
    val array = arrayOf<Double>(5.0, 4.0, 3.0, 2.0, 1.0, 0.0);

    println(sortedSquaredMethod1(array).joinToString());
}

fun sortedSquaredMethod1(array: Array<Double>): Array<Double> {
    var newArray = arrayOf<Double>();

    for ((i, _) in array.withIndex()) {
        val base = array[i];
        newArray += base.pow(2);
    }

    newArray.sort();
    return newArray;
}