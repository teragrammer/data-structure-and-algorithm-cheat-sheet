/*
* Given an array of integers nums and an integer target, 
* return indices of the two numbers such that 
* they add up to target.
*/

List<int> twoSumMethod1(List<int> nums, int target) {
    List<int> indices = List.filled(2, -1);
    int size = nums.length;

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

List<int> twoSumMethod2(List<int> nums, int target) {
    List<int> indices = List.filled(2, -1);
    int size = nums.length;
    var lookup = {};

    for (int i = 0; i < size; i++) {
        int result = target - nums[i];

        if (lookup.containsKey(result)) {
            indices[0] = lookup[result];
            indices[1] = i;
            return indices;
        }

        lookup[nums[i]] = i;
    }

    return indices;
}

void main() {
    List<int> nums = [6, 3, 1, 5, 2];
    var target = 7;

    print(twoSumMethod1(nums, target));
    print(twoSumMethod2(nums, target));
}