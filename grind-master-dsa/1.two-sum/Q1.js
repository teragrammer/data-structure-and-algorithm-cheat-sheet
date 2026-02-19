/*
* Given an array of integers nums and an integer target, 
* return indices of the two numbers such that 
* they add up to target.
*/

const nums = [6, 3, 1, 5, 2];
const target = 7;

console.log(twoSumMethod1(nums, target));
console.log(twoSumMethod2(nums, target));

function twoSumMethod1(nums, target) {
    const indices = [-1, -1];
    const size = nums.length;

    for (let i = 0; i < size; i++) {
        for (let j = i + 1; j < size; j++) {
            const sum = nums[i] + nums[j];
            if (sum === target) {
                indices[0] = i;
                indices[1] = j;
                return indices;
            }
        }
    }

    return indices;
}

function twoSumMethod2(nums, target) {
    const indices = [-1, -1];
    const lookup = new Map();
    const size = nums.length;

    for (let i = 0; i < size; i++) {
        const difference = target - nums[i];
        if (lookup.has(difference)) {
            indices[0] = lookup.get(difference);
            indices[1] = i;
            return indices;
        }
        lookup.set(nums[i], i);
    }

    return indices;
}