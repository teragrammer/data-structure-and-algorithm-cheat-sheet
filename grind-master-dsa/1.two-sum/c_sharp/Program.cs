using System.Collections.Generic;

/*
* Given an array of integers nums and an integer target, 
* return indices of the two numbers such that 
* they add up to target.
*/

int[] TwoSumMethod1(int[] nums, int target)
{
    int[] indices = [-1, -1];
    int size = nums.Length;

    for (int i = 0; i < size; i++)
    {
        for (int j = i + 1; j < size; j++)
        {
            int result = nums[i] + nums[j];
            if (result == target)
            {
                indices[0] = i;
                indices[1] = j;
                return indices;
            }
        }
    }

    return indices;
}

int[] TwoSumMethod2(int[] nums, int target)
{
    int size = nums.Length;
    int[] indices = [-1, -1];
    Dictionary<int, int> lookup = new Dictionary<int, int>();

    for (int i = 0; i < size; i++)
    {
        int result = target - nums[i];

        if (lookup.ContainsKey(result))
        {
            indices[0] = lookup[result];
            indices[1] = i;
            return indices;
        }

        lookup[nums[i]] = i;
    }

    return indices;
}

int[] nums = [6, 3, 1, 5, 2];
int target = 7;

int[] method1 = TwoSumMethod1(nums, target);
if (method1[0] != -1 && method1[1] != -1)
{
    Console.WriteLine("Method 1: " + method1[0] + "," + method1[1] + ": " + (nums[method1[0]] + nums[method1[1]]));
}

int[] method2 = TwoSumMethod2(nums, target);
if (method2[0] != -1 && method2[1] != -1)
{
    Console.WriteLine("Method 2: " + method2[0] + "," + method2[1] + ": " + (nums[method2[0]] + nums[method2[1]]));
}