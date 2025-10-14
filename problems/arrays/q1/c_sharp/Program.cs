/**
 * Sorted Squared Array - You are given an array of 
 * Integers in which each subsequent value is not 
 * less than the previous value. Write a function 
 * that takes this array as an input and returns a 
 * new array with the squares of each number sorted 
 * in ascending order.
 */

int[] SortedSquaredMethod1(int[] array)
{
    int[] newArray = new int[array.Length];

    for (int i = 0; i < array.Length; i++)
    {
        newArray[i] = (int)Math.Pow(array[i], 2);
    }

    return BubbleSortAlgorithm(newArray);
}

int[] SortedArrayMethod2(int[] array) 
{
    int[] newArray = new int[array.Length];

    int leftPointer = 0;
    int rightPointer = array.Length - 1;

    for (int i = 0; i < array.Length; i++) 
    {
        int sqauredLeft = (int) Math.Pow(array[leftPointer], 2);
        int squaredRight = (int) Math.Pow(array[rightPointer], 2);

        if (sqauredLeft < squaredRight)
        {
            newArray[i] = sqauredLeft;
            leftPointer++;
        }
        else
        {
            newArray[i] = squaredRight;
            rightPointer--;
        }
    }

    return newArray;
}

int[] BubbleSortAlgorithm(int[] array)
{
    int size = array.Length;

    for (int i = 0; i < size - 1; i++)
    {
        for (int j = 0; j < size - i - 1; j++)
        {
            if (array[j] > array[j + 1])
            {
                (array[j + 1], array[j]) = (array[j], array[j + 1]);
            }
        }
    }

    return array;
}

int[] array = [5, 4, 3, 2, 1, 0];

Console.WriteLine(string.Join(", ", SortedSquaredMethod1(array)));
Console.WriteLine(string.Join(", ", SortedArrayMethod2(array)));