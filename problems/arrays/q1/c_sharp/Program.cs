int[] SortedSquaredMethod1(int[] array)
{
    int[] newArray = new int[array.Length];

    for (int i = 0; i < array.Length; i++)
    {
        newArray[i] = (int)Math.Pow(array[i], 2);
    }

    return BubbleSortAlgorithm(newArray);
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