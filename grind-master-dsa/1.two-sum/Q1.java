import java.util.Arrays;
import java.util.HashMap;

/*
* Given an array of integers nums and an integer target, 
* return indices of the two numbers such that 
* they add up to target.
*/

public class Q1 {
    public static void main(String[] args) {
        int[] nums = {6, 3, 1, 5, 2};
        int target = 7;

        System.out.println(Arrays.toString(twoSumMethod1(nums, target)));
        System.out.println(Arrays.toString(twoSumMethod2(nums, target)));
    }

    static int[] twoSumMethod1(int[] nums, int target) {
        int[] indices = {-1, -1};
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

    static int[] twoSumMethod2(int[] nums, int target) {
        int[] indices = {-1, -1};
        int size = nums.length;
        HashMap<Integer, Integer> lookup = new HashMap<>();

        for (int i = 0; i < size; i++) {
            int neededNumber = target - nums[i];
            if (lookup.containsKey(neededNumber)) {
                indices[0] = lookup.get(neededNumber);
                indices[1] = i;
                return indices;
            }
            lookup.put(nums[i], i);
        }

        return indices;
    }
}