/*
* Given an array of integers nums and an integer target, 
* return indices of the two numbers such that 
* they add up to target.
*/

fun main() {
    var nums = arrayOf<Int>(6, 3, 1, 5, 2);
    var target = 7;

    println(twoSumMethod1(nums, target).joinToString());
    println(twoSumMethod2(nums, target).joinToString());
}

fun twoSumMethod1(nums: Array<Int>, target: Int): Array<Int> {
    var indices = arrayOf<Int>(-1, -1);

    for ((i, v) in nums.withIndex()) {
        for ((j, m) in nums.slice(i + 1..nums.size - 1).withIndex()) {
            var sum = v + m;
            if (sum == target) {
                indices[0] = i;
                indices[1] = j + i + 1;
                return indices;
            }
        }
    }

    return indices;
}

fun twoSumMethod2(nums: Array<Int>, target: Int): Array<Int> {
    var indices = arrayOf<Int>(-1, -1);
    val lookup: HashMap<Int, Int> = HashMap();

    for ((i, v) in nums.withIndex()) {
        var neededNumber = target - v;

        if (lookup.containsKey(neededNumber)) {
            indices[0] = lookup.getOrDefault(neededNumber, -1);
            indices[1] = i;
            return indices;
        }

        lookup[v] = i;
    }

    return indices;
}